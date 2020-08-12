package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import exceptions.RowsPerPagesException;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer.displayerTools.viewTools.FrontViewList;


@Service
public class DataListInListDisplayImplemented  implements DataListInListDisplay {

	@Autowired
	HttpServletRequest request;

	@Autowired
	MessageSource messageSource;

	private FrontViewList<Object> frontViewList =new FrontViewList<>();


	private ModelAndView frontView = new ModelAndView();



	private String forwardTo(String handlerName) {
		String forward = "forward:";
		return forward.concat(handlerName);
	}

	private String redirectTo(String handlerName) {
		String redirect = "redirect:";
		return redirect.concat(handlerName);//.concat(".html")
	}

	@Override
	public void listInListChangeDefaultRowsPerPagesTo(Integer defaultRowsPerPages) {
		frontViewList.setDefaultRowsPerPages(defaultRowsPerPages);

	}

	@Override
	public void listInListChangeRowsPerPagesListTo(Integer[] rowsPerPagesList) {
		frontViewList.setRowsPerPagesList(rowsPerPagesList);
	}

	@Override
	public void listInListChangeFrontViewStoreFilterName(String frontViewStoreFilterName) {
		frontViewList.setFrontViewStoreFilterName(frontViewStoreFilterName);
	}


	@Override
	// inital entyModel = O entityModel
	public ModelAndView initiatePagelistInList(List<?> fullData, Object entityModel,
			String frontViewAddObjectHandlerName,String internationalizationSuffix) {
		frontViewList  = new FrontViewList<>();
		List<Object> list = new ArrayList<>(fullData);
		frontViewList.setTools(entityModel);//(List<Object>)fullData
		frontViewList.initializingComponents(list, request, messageSource, frontViewList.getRowsPerPagesList(),
				frontViewList.getDefaultRowsPerPages(),internationalizationSuffix);
		frontView.setViewName(forwardTo(frontViewAddObjectHandlerName));
		frontViewList.setFieldName(null);
		return frontView;
	}



	@Override
	public ModelAndView setDataToDisplaylistInList(String frontViewAddObjectHandlerName,List<?> fullData) {
		frontView.setViewName(redirectTo(frontViewAddObjectHandlerName));
		List<Object> list = new ArrayList<>(fullData);
		try {
			frontViewList.setComponentsToDisplay(list);
		} catch (Exception e) {
			frontViewList.setDataToSend(frontViewList.getEmptyArray());
		}
		return frontView;
	}

	@Override
	public ModelAndView frontViewAddObjectlistInList(String jspFolderName, String jspName, String sortListHandlerName,
			String rowsDisplayedHandlerName, String selectPageHandlerName, String orderListHandlerName,String editHandlerName,String listName) {
		if (frontViewList.getFullData().isEmpty()) {
			return new ModelAndView(redirectTo(jspName));
		}
		return frontViewList.addRequiredObject(frontView, jspFolderName, jspName, sortListHandlerName,
				rowsDisplayedHandlerName, selectPageHandlerName, orderListHandlerName,editHandlerName,listName);
	}

	@Override
	public ModelAndView sortlistInList(String setDataToDisplayHandlerName,String jspName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		frontViewList.setFiltersCriteria(request.getParameter(frontViewList.getFrontViewStoreFilterName()), "all");
		if (frontViewList.getCriteria().isEmpty()) {
			return new ModelAndView(redirectTo(jspName));
		}
		return frontView;
	}

	@Override
	public ModelAndView listRowsDisplayedlistInList(String setDataToDisplayHandlerName, String frontViewAddObjectHandlerName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		try {
			frontViewList.setRowsPerPagesSelected(Integer.parseInt(request.getParameter("rowsPerPages")));
		} catch (NumberFormatException | RowsPerPagesException e) {
			return new ModelAndView(forwardTo(frontViewAddObjectHandlerName));
		}
		if (frontViewList.getDataToSend().get(0).equals(frontViewList.getEmpty())
				|| frontViewList.getDataOrdered().isEmpty()) {
			frontViewList.setPage(0);
			return new ModelAndView(forwardTo(frontViewAddObjectHandlerName));
		}
		frontViewList.setPage(1);
		return frontView;
	}

	@Override
	public ModelAndView selectedPagelistInList(String setDataToDisplayHandlerName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		frontViewList.setPage(Integer.parseInt(request.getParameter("page")));
		return frontView;
	}

	@Override
	public ModelAndView orderedPagelistInList(String setDataToDisplayHandlerName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		frontViewList.setOrderWay(request.getParameter("orderWay"));
		frontViewList.setFieldName(request.getParameter("column"));
		frontViewList.setPage(1);
		return frontView;
	}


}
