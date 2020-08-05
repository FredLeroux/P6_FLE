package std.fle._12_controller.controllerClass.listController;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.controllerTools.listManagement.SetListInListManagementController;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer.DataListInListDisplay;

/**
 *
 * @author Frederic Leroux <br>
 *
 *         Allow to display an list after a selection via a first list, this
 *         gives both list to be independent
 *
 */
@Controller
public class DisplayListInListController implements SetListInListManagementController {

	@Autowired
	private DataListInListDisplay dataListInListDisplay;

	@Override
	public DataListInListDisplay listInListControllerConfig() {
		return dataListInListDisplay;
	}

	private String editControllerURI = null;
	private String listName = null;
	private List<?> listInList = null;
	private Object clazzListInList = null;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/04_listPage/listInListPage")
	@Override
	public ModelAndView initiatePageListInList(ModelAndView model, HttpServletRequest request) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map = (LinkedHashMap<String, Object>) request.getAttribute("map");
		if (map != null) {
			listInList = (List<?>) map.get("list");
			clazzListInList = map.get("class");
			editControllerURI = (String) map.get("editControllerURI");
			listName = (String) map.get("listName");
		}
		return listInListControllerConfig().initiatePagelistInList(listInList, clazzListInList,
				"listInListfrontViewAddObject", "label");

	}

	@GetMapping(value = "04_listPage/listInListfrontViewAddObject")
	@Override
	public ModelAndView frontViewAddObjectListInList() {
		return listInListControllerConfig().frontViewAddObjectlistInList("04_listPage", "listInListPage",
				"listInListsortList", "listInListRowsDisplayer", "listInListselectedPage", "listInListorderedPage",
				editControllerURI, listName);
	}

	@GetMapping(value = "04_listPage/listInListsetDataToDisplay")
	@Override
	public ModelAndView setDataToDisplayListInList() {
		return listInListControllerConfig().setDataToDisplaylistInList("listInListfrontViewAddObject");
	}

	@GetMapping(value = "04_listPage/listInListsortList")
	public ModelAndView sortListInList() {
		return listInListControllerConfig().sortlistInList("listInListsetDataToDisplay", "listInListPage");
	}

	@GetMapping(value = "04_listPage/listInListRowsDisplayer")
	@Override
	public ModelAndView listRowsDisplayedListInList() {
		return listInListControllerConfig().listRowsDisplayedlistInList("listInListsetDataToDisplay",
				"listInListfrontViewAddObject");
	}

	@GetMapping(value = "04_listPage/listInListselectedPage")
	@Override
	public ModelAndView selectedPageListInList() {
		return listInListControllerConfig().selectedPagelistInList("listInListsetDataToDisplay");
	}

	@GetMapping(value = "04_listPage/listInListorderedPage")
	@Override
	public ModelAndView orderedPageListInList() {
		return listInListControllerConfig().orderedPagelistInList("listInListsetDataToDisplay");
	}

}
