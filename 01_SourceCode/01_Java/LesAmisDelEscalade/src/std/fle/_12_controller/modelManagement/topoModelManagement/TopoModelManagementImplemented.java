package std.fle._12_controller.modelManagement.topoModelManagement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.StreamListFilter;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._00_general.SessionVariables;
import std.fle._01_entity.assetsEnum.LendingStatus;
import std.fle._02_dto.modelsDTO.topoDTO.TopoLendingDTO;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._05_slo.innerJoinSLO.TopoBorrowSLO;
import std.fle._07_service.TopoListService.TopoListService;
import std.fle._07_service.climbingTopoService.TopoService;
import std.fle._07_service.usersInfoService.UsersInfoService;
import std.fle._09_mailCreation.MailCreator;
import std.fle._10_security.SecurityLevel;
import std.fle._12_controller.modelManagement.deleteManager.DeleteConfirmationManager;
import std.fle._12_controller.modelManagement.formsValidation.FormsValidation;

@Service
public class TopoModelManagementImplemented implements TopoModelManagement {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SelectInputForController selectFieldManager;

	@Autowired
	private TopoService topoService;

	@Autowired
	private TopoListService topoListService;

	@Autowired
	private UsersInfoService usersInfoService;

	@Autowired
	private MailCreator mail;

	@Autowired
	private FormsValidation formsValidation;

	@Autowired
	private LocalMessage local;

	@Autowired
	private DeleteConfirmationManager deleteTopo;

	private SessionVariables sessVar = new SessionVariables();
	private Integer climbingTopoId = null;

	@Override
	public ModelAndView manageDisplayCreateNewTopoForm(ModelAndView model, ClimbingTopoSFC climbingTopoSFC) {
		model.setViewName("05_topo/createNewTopoForm");
		selectFieldManager.addSelectListsAndValues(climbingTopoSFC, model);
		return model;
	}

	@Override
	public ModelAndView manageCreateNewTopo(ModelAndView model, ClimbingTopoSFC climbingTopoSFC,
			String modelAttributeName, BindingResult results) {
		formsValidation.checkStateNotEmpty(climbingTopoSFC, modelAttributeName, results);
		if (results.hasErrors()) {
			model.setViewName("05_topo/createNewTopoForm");
			selectFieldManager.selectListAndValueOnBindingError(climbingTopoSFC, model);
			return model;
		}
		topoService.saveNewTopo(climbingTopoSFC, loggedUserAccountId());
		return new ModelAndView("redirect:/05_topo/createNewTopoForm");
	}

	@Override
	public ModelAndView manageRedirectToUpdateForm(Integer id) {
		climbingTopoId = id;
		return new ModelAndView("redirect:/05_topo/displayUpdateForm");
	}

	@Override
	public ModelAndView manageDisplayClimbingTopo(ModelAndView model, String modelAttributeName,
			ClimbingTopoSFC climbingTopoSFC) {
		model.setViewName("05_topo/updateTopoForm");
		model.addObject(modelAttributeName, topoService.getClimbingTopoSFC(climbingTopoId));
		deleteTopo.addURLAndMessage(model, "deleteTopo", "deleteTopoConfirmationAsk.message");
		selectFieldManager.addSelectListsAndValues(topoService.getClimbingTopoSFC(climbingTopoId), model);
		return model;
	}

	@Override
	public ModelAndView manageUpdateTopo(ModelAndView model, ClimbingTopoSFC climbingTopoSFC, String modelAttributeName,
			BindingResult results) {
		formsValidation.checkStateNotEmpty(climbingTopoSFC, modelAttributeName, results);
		if (results.hasErrors()) {
			model.setViewName("05_topo/updateTopoForm");
			selectFieldManager.selectListAndValueOnBindingError(climbingTopoSFC, model);
			return model;
		}
		topoService.updateClimbingTopo(climbingTopoSFC, loggedUserAccountId());
		model.setViewName("redirect:/04_listPage/listPage");
		return model;
	}

	private Integer loggedUserAccountId() {
		sessVar.setRequest(request);
		return sessVar.getAccountID();
	}

	@Override
	public ModelAndView manageAccessToTopoLending(Integer id) {
		sessVar.setRequest(request);
		if (sessVar.getSecurityLevel() > SecurityLevel.USER.rank()) {
			return new ModelAndView("redirect:/03_messagesPages/topoLendingRefused");
		} else {
			return new ModelAndView("redirect:/05_topo/displayTopodetails/" + id);
		}
	}

	@Override
	public ModelAndView manageDisplayTopoDetails(ModelAndView model, String modelAttributeName, Integer id) {
		model.setViewName("05_topo/displayTopoForm");
		model.addObject(modelAttributeName, topoService.getClimbingTopoDisplayDTO(id));
		return model;
	}

	@Override
	public ModelAndView manageBorrowThisTopo(ClimbingTopoDisplaySFC climbingTopoDisplaySFC,
			HttpServletRequest request) {
		sessVar.setRequest(request);
		mail.sendBorrowDemandNotificationAndConfirmation(topoService.getOwnerMail(climbingTopoDisplaySFC.getOwner()),
				sessVar.getPseudo(), request, usersInfoService.getAccountEmailByLogin(sessVar.getLogin()),
				climbingTopoDisplaySFC.getOwner(), climbingTopoDisplaySFC.getTitle());
		topoService.borrowThisTopo(climbingTopoDisplaySFC.getId(), sessVar.getAccountID(),
				climbingTopoDisplaySFC.getOwner());
		return new ModelAndView("redirect:/04_listPage/listPage");
	}

	@Override
	public ModelAndView manageBorrowDemandsList(ModelAndView model) {
		model.setViewName("05_topo/borrowDemandsList");
		model.addObject("borrowList", waitingBorrowDemandList());
		model.addObject("borrowDemand", numberOfWaitingBorrowDemand());
		return model;
	}

	@Override
	public Integer numberOfWaitingBorrowDemand() {
			return waitingBorrowDemandList().size();
	}

	/**
	 *
	 * @return only logged user waiting borrow demand list
	 */
	private List<TopoBorrowSLO> waitingBorrowDemandList() {
		sessVar.setRequest(request);
		return StreamListFilter.getPredicateFilteredList(topoListService.getBorrowingDemandList(sessVar.getAccountID()),
				predicateByLendinStatusEqualsTo(local.message(LendingStatus.WAITING.toString().concat(".name"))));
	}

	private Predicate<TopoBorrowSLO> predicateByLendinStatusEqualsTo(String filter) {
		Predicate<TopoBorrowSLO> predicate = o -> o.getLendingStatus().equals(filter);
		return predicate;
	}

	@Override
	public ModelAndView manageSeeDemand() {
		return new ModelAndView("05_topo/acceptOrNot");

	}

	@Override
	public ModelAndView manageDemandeAccepted(ModelAndView model, String redirectTo) {
		Integer id = topoLendingIdOnRequest();
		if (securityLenderCheck(id)) {
			topoService.borrowDemandAccepted(id);
			sendDemandAcceptedEmail(id);
			model.setViewName("redirect:/".concat(redirectTo));
		} else {
			model.setViewName("03_messagesPages/accesDenied");
		}
		return model;
	}

	@Override
	public ModelAndView manageDemandeRejected(ModelAndView model, String redirectTo) {
		Integer id = topoLendingIdOnRequest();
		if (securityLenderCheck(id)) {
			topoService.borrowDemandRejected(id);
			sendDemanRejectedEmail(id);
			model.setViewName("redirect:/".concat(redirectTo));
		} else {
			model.setViewName("03_messagesPages/accesDenied");
		}
		return model;
	}

	@Override
	public ModelAndView manageBorrowDemand(ModelAndView model, String redirectTo) {
		Integer id = topoLendingIdOnRequest();
		if (securityLenderCheck(id)) {
			if (borrowDemandAccepted()) {
				topoService.borrowDemandAccepted(id);
				sendDemandAcceptedEmail(id);
			} else {
				topoService.borrowDemandRejected(id);
				sendDemanRejectedEmail(id);
			}
			model.setViewName("redirect:/".concat(redirectTo));
		} else {
			model.setViewName("03_messagesPages/accesDenied");
		}
		waitAsyncReady(1/10);
							/*
							 * No choice than wait causse some issues on Async mail sometime send to wrong
							 * person some time not send at all, this 2 sec wait allow to solve this issue
							 */
		return model;
	}

	private void waitAsyncReady(Integer seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Integer topoLendingIdOnRequest() {
		return FredParser.toInteger(request.getParameter("id"));
	}

	private boolean borrowDemandAccepted() {
		return request.getParameter("demand").equals("accepted");
	}

	private boolean securityLenderCheck(Integer topoLendingId) {
		sessVar.setRequest(request);
		return topoService.lenderCheck(topoLendingId, sessVar.getAccountID());
	}

	private void sendDemandAcceptedEmail(Integer id) {
		TopoLendingDTO dto = topoService.getTopoLendingById(id);
		String lenderEmail = dto.getLenderUserInfo().getEmail();
		String borrowerEmail = dto.getBorrowerUserInfo().getEmail();
		String lenderPseudo = dto.getLenderUserInfo().getUserAccountInfo().getPseudonyme();
		String borrowerPseudo = dto.getBorrowerUserInfo().getUserAccountInfo().getPseudonyme();
		String topoTitle = dto.getClimbingTopo().getTitle();
		mail.sendBorrowingDemandAcceptedMails(lenderPseudo, lenderEmail, borrowerPseudo, borrowerEmail, topoTitle);

	}

	private void sendDemanRejectedEmail(Integer id) {
		TopoLendingDTO dto = topoService.getTopoLendingById(id);
		String borrowerEmail = dto.getBorrowerUserInfo().getEmail();
		String lenderPseudo = dto.getLenderUserInfo().getUserAccountInfo().getPseudonyme();
		String topoTitle = dto.getClimbingTopo().getTitle();
		mail.sendBorrowDemandRejectedToBorrower(borrowerEmail, topoTitle, lenderPseudo);
	}

	@Override
	public ModelAndView manageDeleteTopo() {
		topoService.deleteTopo(climbingTopoId);
		return new ModelAndView("redirect:/04_listPage/listPage");
	}

}
