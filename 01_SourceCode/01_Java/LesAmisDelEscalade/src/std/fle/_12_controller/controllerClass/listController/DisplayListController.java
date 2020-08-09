package std.fle._12_controller.controllerClass.listController;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.controllerTools.listManagement.SetListManagementController;
import fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer.DataListDisplay;

@Controller
public class DisplayListController implements SetListManagementController {

	@Autowired
	private DataListDisplay dataListDisplay;

	@Override
	public DataListDisplay listControllerConfig() {
		return dataListDisplay;
	}

	private String editControllerURI = null;
	private String listName = null;
	private String listType = null;
	private List<?> list = null;
	private Object clazz = null;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "04_listPage/setListPage")
	@Override
	public ModelAndView initiatePage(ModelAndView model, HttpServletRequest request) {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map = (LinkedHashMap<String, Object>) request.getAttribute("map");
		if (map != null) {
			list = (List<?>) map.get("list");
			clazz = map.get("class");
			editControllerURI = (String) map.get("editControllerURI");
			listName = (String) map.get("listName");
			listType = (String) map.get("listType");
		}
		return listControllerConfig().initiatePage(list, clazz, "frontViewAddObject", "label");// model; //list, clazz
	}

	@GetMapping(value = "04_listPage/frontViewAddObject")
	@Override
	public ModelAndView frontViewAddObject() {
		return listControllerConfig().frontViewAddObject("04_listPage", "listPage", "sortList", "listRowsDisplayer",
				"selectedPage", "orderedPage", editControllerURI, listName);
	}

	@GetMapping(value = "04_listPage/listPage")
	public ModelAndView base() {
		return new ModelAndView("redirect:setListPage?listType=" + listType);
	}


	@GetMapping(value = "04_listPage/setDataToDisplay")
	@Override
	public ModelAndView setDataToDisplay() {
		return listControllerConfig().setDataToDisplay("frontViewAddObject");
	}

	@GetMapping(value = "04_listPage/sortList")
	@Override
	public ModelAndView sortList() {
		return listControllerConfig().sortList("setDataToDisplay", "listPage");
	}

	@GetMapping(value = "04_listPage/listRowsDisplayer")
	@Override
	public ModelAndView listRowsDisplayed() {
		return listControllerConfig().listRowsDisplayed("setDataToDisplay", "frontViewAddObject");
	}

	@GetMapping(value = "04_listPage/selectedPage")
	@Override
	public ModelAndView selectedPage() {
		return listControllerConfig().selectedPage("setDataToDisplay");
	}

	@GetMapping(value = "04_listPage/orderedPage")
	@Override
	public ModelAndView orderedPage() {
		return listControllerConfig().orderedPage("setDataToDisplay");
	}

}
