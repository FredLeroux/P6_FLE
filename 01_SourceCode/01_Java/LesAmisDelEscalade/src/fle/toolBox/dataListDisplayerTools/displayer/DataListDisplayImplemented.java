package fle.toolBox.dataListDisplayerTools.displayer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import exceptions.RowsPerPagesException;
import fle.toolBox.dataListDisplayerTools.displayer.displayerTools.viewTools.FrontViewList;


@Service
public class DataListDisplayImplemented implements DataListDisplay {

	@Autowired
	HttpServletRequest request;

	@Autowired
	MessageSource messageSource;

	private FrontViewList<Object> frontViewList = new FrontViewList<>();
	

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
	public void changeDefaultRowsPerPagesTo(Integer defaultRowsPerPages) {
		frontViewList.setDefaultRowsPerPages(defaultRowsPerPages);

	}

	@Override
	public void changeRowsPerPagesListTo(Integer[] rowsPerPagesList) {
		frontViewList.setRowsPerPagesList(rowsPerPagesList);
	}

	@Override
	public void changeFrontViewStoreFilterName(String frontViewStoreFilterName) {
		frontViewList.setFrontViewStoreFilterName(frontViewStoreFilterName);
	}

	
	@Override
	// inital entyModel = O entityModel
	public ModelAndView initiatePage(List<?> fullData, Object entityModel,
			String frontViewAddObjectHandlerName,String internationalizationSuffix) {
		List<Object> list = new ArrayList<>(fullData);
		frontViewList.setTools(entityModel);//(List<Object>)fullData
		frontViewList.initializingComponents(list, request, messageSource, frontViewList.getRowsPerPagesList(),
				frontViewList.getDefaultRowsPerPages(),internationalizationSuffix);
		frontView.setViewName(forwardTo(frontViewAddObjectHandlerName));
		frontViewList.setFieldName(null);
		return frontView;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView setDataToDisplay(String frontViewAddObjectHandlerName) {
		frontView.setViewName(redirectTo(frontViewAddObjectHandlerName));
		try {
			frontViewList.setComponentsToDisplay();
		} catch (Exception e) {
			frontViewList.setDataToSend(frontViewList.getEmptyArray());
		}
		return frontView;
	}

	@Override
	public ModelAndView frontViewAddObject(String jspFolderName, String jspName, String sortListHandlerName,
			String rowsDisplayedHandlerName, String selectPageHandlerName, String orderListHandlerName,String editHandlerName) {
		if (frontViewList.getFullData().isEmpty()) {
			return new ModelAndView(redirectTo(jspName));
		}
		return frontViewList.addRequiredObject(frontView, jspFolderName, jspName, sortListHandlerName,
				rowsDisplayedHandlerName, selectPageHandlerName, orderListHandlerName,editHandlerName);
	}

	@Override
	public ModelAndView sortList(String setDataToDisplayHandlerName,String jspName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		frontViewList.setFiltersCriteria(request.getParameter(frontViewList.getFrontViewStoreFilterName()), "all");
		if (frontViewList.getCriteria().isEmpty()) {
			return new ModelAndView(redirectTo(jspName));
		}
		return frontView;
	}

	@Override
	public ModelAndView listRowsDisplayed(String setDataToDisplayHandlerName, String frontViewAddObjectHandlerName) {
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
	public ModelAndView selectedPage(String setDataToDisplayHandlerName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		frontViewList.setPage(Integer.parseInt(request.getParameter("page")));
		return frontView;
	}

	@Override
	public ModelAndView orderedPage(String setDataToDisplayHandlerName) {
		frontView.setViewName(forwardTo(setDataToDisplayHandlerName));
		frontViewList.setOrderWay(request.getParameter("orderWay"));
		frontViewList.setFieldName(request.getParameter("column"));
		frontViewList.setPage(1);
		return frontView;
	}

}
