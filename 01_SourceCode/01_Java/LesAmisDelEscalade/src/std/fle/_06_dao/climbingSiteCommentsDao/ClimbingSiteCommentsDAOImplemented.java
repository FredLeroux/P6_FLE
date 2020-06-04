package std.fle._06_dao.climbingSiteCommentsDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fle.toolBox.StringExtractor;
import fle.toolBox.CRUD.dao.DAOGenericInterface;
import fle.toolBox.CRUD.daoList.DAOListGeneric;
import fle.toolBox.Internationalization.Internationalization;
import fle.toolBox.Internationalization.LocalMessage;
import std.fle._01_entity.models.site.ClimbingSiteComments;
import std.fle._01_entity.models.site.CommentsModificationLog;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteCommentsDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteCommentsEditDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.ClimbingSiteDTO;
import std.fle._02_dto.modelsDTO.climbingSiteDTO.CommentsModificationLogDTO;
import std.fle._02_dto.modelsDTO.usersDTO.usersAccountInfoDTO.UsersAccountInfoDTO;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._06_dao.climbingSiteDao.ClimbingSiteDAO;
import std.fle._06_dao.usersAccountInfoDao.UsersAccountInfoDAO;

@Repository
public class ClimbingSiteCommentsDAOImplemented implements ClimbingSiteCommentsDAO {

	@Autowired
	private LocalMessage localMessage;

	@Autowired
	private DAOGenericInterface<ClimbingSiteComments, ClimbingSiteCommentsDTO> dao;

	@Autowired
	private DAOListGeneric daoList;

	@Autowired
	private ClimbingSiteDAO siteDao;

	@Autowired
	private UsersAccountInfoDAO userDao;

	private StringExtractor extractor = new StringExtractor();
	private Internationalization inter = new Internationalization();
	private ClimbingSiteComments climbingSiteComments = new ClimbingSiteComments();
	private CommentsModificationLog commentsModificationLog = new CommentsModificationLog();
	private ClimbingSiteCommentsDTO climbingSiteCommentsDTO = new ClimbingSiteCommentsDTO();
	private ClimbingSiteCommentsEditDTO climbingSiteCommentsEditDTO = new ClimbingSiteCommentsEditDTO();
	private CommentsModificationLogDTO commentsModificationLogDTO = new CommentsModificationLogDTO();
	private ClimbingSiteCommentsSFC climbingSiteCommentsSFC = new ClimbingSiteCommentsSFC();
	
	private String originalComment = null;
	private String charLimiter = "*";
	private String modifyBy = "modifyBy.label";
	private String the = "the.label";
	private String was = "was.label";
	private String deleted = "deleted.label";
	

	@Override
	public void postComment(Integer climbingSiteId, Integer userAccountId, String comment) {
		dao.saveDTO(climbingSiteComments, climbingSiteCommentsDTO(climbingSiteId, userAccountId, comment));
	}

	private ClimbingSiteCommentsDTO climbingSiteCommentsDTO(Integer climbingSiteId, Integer userAccountId,
			String comment) {
		ClimbingSiteCommentsDTO dto = new ClimbingSiteCommentsDTO();
		dto.setClimbingSite(climbingSiteDTO(climbingSiteId));
		dto.setUsersAccountInfo(usersAccountInfoDTO(userAccountId));
		dto.setComment(commentParseToFrontString(comment));
		System.out.println(LocalDateTime.now());
		dto.setPostDate(LocalDateTime.now());
		return dto;
	}

	private ClimbingSiteDTO climbingSiteDTO(Integer climbingSiteId) {
		ClimbingSiteDTO dto = siteDao.getClimbingSiteDTOById(climbingSiteId);
		return dto;
	}

	private UsersAccountInfoDTO usersAccountInfoDTO(Integer userAccountId) {
		UsersAccountInfoDTO dto = userDao.getDTOByID(userAccountId);
		return dto;
	}

	@Override
	public ClimbingSiteCommentsSFC getClimbingSiteCommentsSFCForEdit(Integer id) {
		ClimbingSiteCommentsEditDTO dto = getClimbingSiteCommentEditDTO(id);
		ClimbingSiteCommentsSFC sfc = dao.converter().convertDTOToSFC(dto, climbingSiteCommentsSFC);
		originalComment = commentTosetOnSFC(dto.getComment());
		sfc.setComment(commentParseToBackString(originalComment));
		return sfc;
	}

	private String commentTosetOnSFC(String originalComment) {
		if (cleanComment(originalComment)) {
			return extractComment(originalComment);
		} else {
			return originalComment;
		}
	}

	private String extractComment(String originalComment) {
		String comment = extractor.extractAllAfterLastIndexOf(originalComment, charLimiter);		
		String commentClean = commentParseToBackString(comment).trim();
		return commentClean;
	}

	private String commentParseToBackString(String str) {
		return str.replace("<br>", "\r\n"); 
	}
	
	private String commentParseToFrontString(String str) {
		return str.replace("\r\n", "<br>");
	}
	
	private boolean cleanComment(String originalComment) {
		return originalComment.contains(charLimiter);

	}

	private ClimbingSiteCommentsEditDTO getClimbingSiteCommentEditDTO(Integer id) {
		return dao.getSpecificDTOById(climbingSiteComments, climbingSiteCommentsEditDTO, id);
	}

	@Override
	public void updateComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC,Integer commentId, String author) {
		updateOrDeleteComment(climbingSiteCommentsSFC,commentId, author, true);
	}
	
	@Override
	public void deleteComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC, Integer commentId,String author) {
		updateOrDeleteComment(climbingSiteCommentsSFC,commentId, author, false);
	}
	
	private void updateOrDeleteComment(ClimbingSiteCommentsSFC climbingSiteCommentsSFC,Integer commentId, String author,boolean update) {
		ClimbingSiteCommentsDTO dto = dao.getDtoByID(climbingSiteComments, climbingSiteCommentsDTO,
				commentId);
		LocalDateTime date = LocalDateTime.now();
		String commentUpdated = null;
		if(update) {
			commentUpdated = climbingSiteCommentsSFC.getComment();
		}else {
			commentUpdated = buildDeleteSentence();
		}		
		dto.setComment(commentWithModificationLog(author, formattedLocalDate(date), commentUpdated));
		conditionnalUpdate(commentUpdated, author, date, dto);
	}

	private void conditionnalUpdate(String commentUpdated, String author, LocalDateTime date, ClimbingSiteCommentsDTO dto) {
		if (!originalComment.equals(commentUpdated)) {	
			dao.updateDTO(climbingSiteComments, dto);
			dao.saveSpecificDTO(commentsModificationLog, modificationLogNewEntry(author, date, dto));
		}
	}

	private String commentWithModificationLog(String author, String date, String comment) {
		return buildModifLog(author, date).concat(commentParseToFrontString(comment));
	}

	private CommentsModificationLogDTO modificationLogNewEntry(String author, LocalDateTime date,
			ClimbingSiteCommentsDTO climbingSiteCommentsDTO) {
		CommentsModificationLogDTO newEntry = new CommentsModificationLogDTO();
		newEntry.setAuthor(author);
		newEntry.setModificationDate(date);
		newEntry.setCommentBefore(commentParseToBackString(originalComment));
		newEntry.setClimbingSiteComments(climbingSiteCommentsDTO);
		return newEntry;
	}

	@Override
	public ArrayList<String> modificationLogI18N(Integer climbingSiteCommentId) {
		ArrayList<String> modificationLogI18N = new ArrayList<>();
		getModificationLogDTOByCommentId(climbingSiteCommentId).forEach(o -> modificationLogI18N.add(
				buildHistoryLog(o.getAuthor(), formattedLocalDate(o.getModificationDate()),commentParseToFrontString(o.getCommentBefore()))));
		return modificationLogI18N;
	}

	private String buildHistoryLog(String author, String date, String commentBefore) {
		return buildModifLog(author, date).concat(localMessage.message(was)).concat("<br>")
				.concat(commentBefore);
	}

	private String buildModifLog(String author, String date) {
		return localMessage.message(modifyBy).concat(author).concat(localMessage.message(the)).concat(date)
				.concat(charLimiter + charLimiter).concat("<br>");
	}

	private List<CommentsModificationLogDTO> getModificationLogDTOByCommentId(Integer climbingSiteCommentId) {
		return getModificationlogByCommentId(climbingSiteCommentId).stream()
				.map(o -> convertCommentsModificationLogToDTO(o)).collect(Collectors.toList());
	}

	private CommentsModificationLogDTO convertCommentsModificationLogToDTO(
			CommentsModificationLog commentsModificationLog) {
		return (CommentsModificationLogDTO) dao.converter().convertSourceToDestinationType(commentsModificationLog,
				commentsModificationLogDTO);
	}

	private List<CommentsModificationLog> getModificationlogByCommentId(Integer climbingSiteCommentId) {
		return daoList.getListOfObjectWhere(commentsModificationLog, "climbingSiteComments.id", climbingSiteCommentId);
	}
//TODO Find a way to get hour and min at save and modif peut eter ajouté le temps manuellemnt
	private String formattedLocalDate(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));//.ofLocalizedDate(FormatStyle.FULL)
	}
	
	private String buildDeleteSentence() {
		return localMessage.message(deleted);
	}

}
