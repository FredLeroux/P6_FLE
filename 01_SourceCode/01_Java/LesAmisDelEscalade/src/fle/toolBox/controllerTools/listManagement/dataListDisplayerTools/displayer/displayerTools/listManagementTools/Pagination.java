package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.displayer.displayerTools.listManagementTools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import exceptions.NoApplicableRuleException;
import exceptions.PageWishedException;
import fle.toolBox.exceptionsThrower.ExceptionsThrower;

public abstract class Pagination<O extends Object> extends FilterAndSortListViaJava<O> {



	private Integer rowsPerPages = null;
	private Integer totalPages = null;
	private Integer listSize = null;
	private List<O> page = null;
	private ArrayList<LinkedHashMap<String, Integer>> rulesList = new ArrayList<>();
	private String minPageKey = "pagesLimitMin";
	private String maxPageKey = "pagesLimitMax";
	private String lowJumpKey = "lowJump";
	private String mediumJumpKey = "mediumJump";
	private String highJumpKey = "highJump";
	private String plus = "Plus";
	private String minus = "Minus";

	public Pagination(O entityModel) {
		super(entityModel);
	}


	protected Integer getRowsPerPages() throws NullPointerException {
		ExceptionsThrower.ifZero(rowsPerPages, "rowsPerPAges = 0");
		return rowsPerPages;
	}

	protected void setRowsPerPages(Integer rowsPerPages) {
		this.rowsPerPages = rowsPerPages;
	}

	protected Integer getTotalPages() throws NullPointerException {
		ExceptionsThrower.ifZero(totalPages, "totalPages = 0 || not setted");
		return totalPages;
	}

	protected void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	protected Integer getListSize() throws NullPointerException {
		ExceptionsThrower.ifZero(listSize, "ListSize = 0");
		return listSize;
	}

	protected void setListSize(Integer listSize) {
		this.listSize = listSize;
	}

	protected Double dividing(Double a, Double b) throws ArithmeticException {
		ExceptionsThrower.ifDivideByZero(b);
		double divideResult = a / b;
		return divideResult;
	}

	protected Integer roundUp(Double toRound) {
		return (int) Math.ceil(toRound);
	}

	protected Double castIntToDouble(Integer toCast) {
		double intToCast = new Double(toCast);
		return intToCast;
	}

	/**
	 * @Set total pages using listSize and rowsPerPages getter, setted via listSize
	 *      and rowsPerPages setter.
	 * @Note will round all non int results listSize/rowsPerPages to the closest
	 *       superiror int<br>
	 *       i.e.<br>
	 *       For a listSize at 110 and a rowsPerpages at 30 given 110/50=2.2 total
	 *       pages will be = 3.<br>
	 *       For a listSize at 120 and a rowsPerpages at 10 given 120/10=12 total
	 *       pages will be = 12.<br>
	 *       For a listSize at 118 and a rowsPerpages at 10 given 118/10=11.8 total
	 *       pages will be = 12. <br>
	 *       For a listSize at 121 and a rowsPerpages at 10 given 118/10=12.1 total
	 *       pages will be = 13.<br>
	 *       return 1 if rowsPerPages >= listSize.
	 * @throws NullPointerException
	 *
	 */
	protected void setTotalPages() {
		double a = 0;
		try {
			a = castIntToDouble(getListSize());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double b = 0;
		try {
			b = castIntToDouble(getRowsPerPages());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double totalPagesCalc = 0;
		try {
			totalPagesCalc = dividing(a, b);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalPages = b > a ? 1 : roundUp(totalPagesCalc);
	}

	/**
	 *
	 * @param listSize
	 * @param rowsPerPages
	 * @return int listSize/rowsPerpPages result rounded up(see setTotalPages()).
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	protected int calculateTotalPages(int listSize, int rowsPerPages) throws NullPointerException, ArithmeticException {
		int result = 0;
		double a = castIntToDouble(listSize);
		double b = castIntToDouble(rowsPerPages);
		double totalPagesCalc = 0;
		ExceptionsThrower.ifZero(listSize, "listSize = 0");
		try {
			totalPagesCalc = dividing(a, b);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = b > a ? 1 : roundUp(totalPagesCalc);
		return result;

	}

	protected List<O> getPage() {
		ExceptionsThrower.ifZero(page.size(), "No page to display: \"Empty Page\" || not setted ");
		return page;
	}

	/**
	 *
	 * @param pageWished the page number's to display
	 * @param list       the list containing rows of interest
	 * @throws PageWishedException
	 * @Set a list containing the exact rows per pages according to an offset
	 *      function of the page number
	 * @Example for a list at 100 rows, the rowsPerpages at 10, and pageWished at
	 *          2<br>
	 *          will set a list(page) containing 10 rows from list containing list
	 *          object index 10 to 20
	 */
	protected void setPage(Integer pageWished, List<O> list) throws PageWishedException {
		List<O> fullList = new ArrayList<O>(list);
		List<O> pageTemp = new ArrayList<O>();
		try {
			if (getTotalPages() < pageWished) {
				throw new PageWishedException();
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int offset = 0;
		try {
			offset = ((pageWished - 1) * getRowsPerPages());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		int max = 0;
		max = (getRowsPerPages() + offset) > fullList.size() ? fullList.size() : (getRowsPerPages() + offset);
		for (i = offset; i < max; i++) {
			pageTemp.add(fullList.get(i));
		}

		page = pageTemp;
		fullList.clear();

	}

	/**
	 *
	 * @param pageWished   the page number's to display
	 * @param rowsPerPages the number of rows displayed by pages
	 * @param pageMax      the maximum pages available
	 * @param list         the list containing rows of interest
	 * @throws PageWishedException
	 * @Set a list containing the exact rows per pages according to an offset
	 *      function of the page number
	 * @Example for a list at 100 rows, the rowsPerpages at 10, and pageWished at
	 *          2<br>
	 *          will set a list(page) containing 10 rows from list containing list
	 *          object index 10 to 20
	 *
	 */
	protected void setPage(Integer pageWished, Integer rowsPerPages, Integer pageMax, List<O> list)
			throws PageWishedException {
		List<O> fullList = new ArrayList<O>(list);
		List<O> pageTemp = new ArrayList<O>();
		if (pageMax < pageWished) {
			throw new PageWishedException();
		}
		int offset = 0;
		offset = ((pageWished - 1) * rowsPerPages);
		int i = 0;
		int max = 0;
		max = (rowsPerPages + offset) > fullList.size() ? fullList.size() : (rowsPerPages + offset);
		for (i = offset; i < max; i++) {
			pageTemp.add(fullList.get(i));
		}

		page = pageTemp;
		fullList.clear();

	}

	/**
	 *
	 * @param page
	 * @param totalPages
	 * @param amplitude
	 * @param empty
	 * @return a string array containing pages:<br>
	 *         -for total pages <= amplitude (fixed to 10) return a string arrayList
	 *         from 1 to 10 <br>
	 *         -for total pages > amplitude return a string array list:<br>
	 *         if page < amplitude return [1->amplitude] <br>
	 *         if page < amplitude return [page minus delta-1(delta= amplitude /2)
	 *         -> page -> page plus delta]<br>
	 *         if page + delta > amplitude return [page - (delta + (high - total
	 *         pages)) -> page -> total page]
	 */
	protected ArrayList<String> basicNav(Integer page, Integer totalPages, String empty) {
		ArrayList<String> navigation = new ArrayList<String>();
		Integer amplitude = 10;
		Integer delta = 5;
		Integer low = 0;
		Integer high = amplitude;
		if (page == 0 || totalPages == 0) {
			navigation.add(empty);
			return navigation;
		}
		if (totalPages <= high) {
			high = totalPages;
		}
		if (page >= amplitude) {
			low = page - delta;
			high = page + delta;
		}
		if (high > totalPages) {
			low = page - (delta + (high - totalPages));
			high = totalPages;
		}
		for (int i = low; i < high; i++) {
			navigation.add(Integer.toString(i + 1));
		}
		return navigation;
	}

	/**
	 *
	 * @param page
	 * @param totalPages
	 * @param rulesList
	 * @return a linkedHashMap containing the jump list in Function of the selected
	 *         page and the rule from the rulesList <br>
	 *         adjust the jump in function of the total pages, plus change to zero
	 *         the jump value if this one is not usefull with the selected page
	 */
	protected ArrayList<String> jumpListFooPage(Integer page, Integer totalPages,
			ArrayList<LinkedHashMap<String, Integer>> rulesList) {
		ArrayList<String> jumpListFooPage = new ArrayList<>();
		LinkedHashMap<String, Integer> jump = null;
		try {
			jump = new LinkedHashMap<>(jumpValue(totalpagesTenPower(totalPages), rulesList));
		} catch (NoApplicableRuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer lowJumpMinus = jump.get(lowJumpKey);
		Integer mediumJumpMinus = jump.get(mediumJumpKey);
		Integer highJumpMinus = jump.get(highJumpKey);
		Integer lowJumpPlus = jump.get(lowJumpKey);
		Integer mediumJumpPlus = jump.get(mediumJumpKey);
		Integer highJumpPlus = jump.get(highJumpKey);
		if (page == lowJumpMinus) {
			lowJumpMinus = 0;
			mediumJumpMinus = 0;
			highJumpMinus = 0;
		} else if (page > lowJumpMinus && page <= mediumJumpMinus) {
			mediumJumpMinus = 0;
			highJumpMinus = 0;
		} else if (page >= mediumJumpMinus && page <= highJumpMinus) {
			highJumpMinus = 0;
		}

		if (page == totalPages) {
			lowJumpPlus = 0;
			mediumJumpPlus = 0;
			highJumpPlus = 0;
		} else if (page > totalPages - mediumJumpPlus && page <= totalPages) {
			mediumJumpPlus = 0;
			highJumpPlus = 0;
		} else if (page > totalPages - highJumpPlus && page <= totalPages - mediumJumpPlus) {
			highJumpPlus = 0;
		}
		jumpListFooPage.add(lowJumpKey + minus+"="+ (-lowJumpMinus));
		jumpListFooPage.add(mediumJumpKey + minus+"="+ (-mediumJumpMinus));
		jumpListFooPage.add(highJumpKey + minus+"="+ (-highJumpMinus));
		jumpListFooPage.add(lowJumpKey + plus+"="+ lowJumpPlus);
		jumpListFooPage.add(mediumJumpKey + plus+"="+ mediumJumpPlus);
		jumpListFooPage.add(highJumpKey + plus+"="+ highJumpPlus);
		return jumpListFooPage;
	}

	/**
	 *
	 * @param totalpagesTenPower
	 * @param rulesList
	 * @return the low medium and high jump set function of the totalPagesTenPower
	 * @throws NoApplicableRuleException
	 */
	protected LinkedHashMap<String, Integer> jumpValue(int totalpagesTenPower,
			ArrayList<LinkedHashMap<String, Integer>> rulesList) throws NoApplicableRuleException {
		LinkedHashMap<String, Integer> jumpList = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> rule = new LinkedHashMap<>();
		boolean iterate = true;
		int i = 1;
		while (iterate) {
			rule = rulesList.get(i - 1);
			if(rule.get(maxPageKey)==-1) {
				iterate = false;
			}
			if (totalpagesTenPower >= rule.get(minPageKey) && totalpagesTenPower <= rule.get(maxPageKey)) {
				iterate = false;
			} else if (i == rulesList.size()) {
				iterate = false;
				throw new NoApplicableRuleException("Not applicable rule for value of :" + totalpagesTenPower);
			}
			i++;
		}
		jumpList.put(lowJumpKey, rule.get(lowJumpKey));
		jumpList.put(mediumJumpKey, rule.get(mediumJumpKey));
		jumpList.put(highJumpKey, rule.get(highJumpKey));
		return jumpList;

	}

	/**
	 *
	 * @param pagesLimitMin
	 * @param pagesLimitMax put -1 to indicate infinite
	 * @param lowJump
	 * @param mediumJump
	 * @param highJump
	 * @return set a linkedHasMap as follow <br>
	 *         String key-> Integer value<br>
	 *         minPageKey-> pagesLimitMin<br>
	 *         maxPageKey-> pagesLimitMax<br>
	 *         lowJumpKey-> lowJump<br>
	 *         mediumJumpKey-> mediumJump<br>
	 *         highJumpKey-> highJump<br>
	 *
	 */
	protected LinkedHashMap<String, Integer> createPagesJumpRule(Integer pagesLimitMin, Integer pagesLimitMax,
			Integer lowJump, Integer mediumJump, Integer highJump) {
		LinkedHashMap<String, Integer> rule = new LinkedHashMap<>();
		rule.put(minPageKey, pagesLimitMin);
		rule.put(maxPageKey, pagesLimitMax);
		rule.put(lowJumpKey, lowJump);
		rule.put(mediumJumpKey, mediumJump);
		rule.put(highJumpKey, highJump);
		return rule;
	}

	/**
	 *
	 * @return a list of LinkedHashMap<String, Integer> pagesJumpRule
	 */
	protected ArrayList<LinkedHashMap<String, Integer>> getRulesList() {
		return rulesList;
	}

	/**
	 *
	 * @param pagesJumpRule
	 */
	protected void addRuleToRulesList(LinkedHashMap<String, Integer> pagesJumpRule) {
		this.rulesList.add(pagesJumpRule);
	}

	/**
	 *
	 * @param totalPages
	 * @return totalPages ten power rounded i.e.<br>
	 *         for a integer value of 2568 return 2000
	 */
	int totalpagesTenPower(Integer totalPages) {
		int logTen = (int) Math.log10(totalPages);
		int multipleTen = (int) Math.pow(10, logTen);
		int totalpagesTenPower = (totalPages / multipleTen) * multipleTen;
		return totalpagesTenPower;
	}


}
