package fle.toolBox.dataListDisplayerTools.displayer.displayerTools.listManagementTools;

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

	// TODO modify
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
//getTendegre
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

/// not used yet may usefull one day 	
	/**
	 * 
	 * @param navigationArray
	 * @param page
	 * @param totalPages
	 * @param trigger         is the mimimum total pages available before add jump
	 *                        totalPages/4 and totalpages/2
	 * @return return navigationArray bounded by "<" and ">" function of first and
	 *         last page i.e. <br>
	 *         if page != 1 add "<" to the start<br>
	 *         if page != total pages add ">" to the end
	 */
/*	private ArrayList<String> addBasicBoundary(ArrayList<String> navigationArray, Integer page, Integer totalPages,
			Integer trigger, Integer lowJump) {
		ArrayList<String> navigation = new ArrayList<String>(navigationArray);
		ArrayList<Integer> highAndMediumTbl = new ArrayList<>();
		// highAndMediumTbl = highAndMedium(totalpagesTenPower(totalPages), trigger);

		String notToDisplay = "n/a";
		int high = highAndMediumTbl.get(0);
		int medium = highAndMediumTbl.get(1);
		String lowJumpStr = notToDisplay;
		String mediumJump = notToDisplay;
		String highJump = notToDisplay;

		if (page != 1) {
			lowJumpStr = Integer.toString(-lowJump);

			if (medium + 1 <= page) {
				if (medium == 0) {
					mediumJump = notToDisplay;
				} else {
					mediumJump = Integer.toString(-medium);
				}
			}
			if (high + 1 <= page) {
				if (high == 0) {
					highJump = notToDisplay;
				} else {
					highJump = Integer.toString(-high);
				}
			}
		}

		navigation.add(0, lowJumpStr);
		navigation.add(0, mediumJump);
		navigation.add(0, highJump);
		lowJumpStr = Integer.toString(lowJump);
		if (medium == 0) {
			mediumJump = notToDisplay;
		} else {
			mediumJump = Integer.toString(medium);
		}
		if (high == 0) {
			highJump = notToDisplay;
		} else {
			highJump = Integer.toString(high);
		}

		if (page >= (totalPages + 1 - high)) {
			highJump = notToDisplay;
		}
		if (page >= (totalPages + 1 - medium)) {
			mediumJump = notToDisplay;
		}
		if (page == totalPages) {
			lowJumpStr = notToDisplay;
		}
		navigation.add(lowJumpStr);
		navigation.add(mediumJump);
		navigation.add(highJump);

		return navigation;
	}

	/**
	 * 
	 * @param page
	 * @param totalPages
	 * @param empty
	 * @return return a string array containing page list and bounded by "<" and/or
	 *         ">" see :<br>
	 *         basicNav<br>
	 *         addBasicBoundary<br>
	 */
	/*private ArrayList<String> basicNavBounded(Integer page, Integer totalPages, String empty, Integer trigger,
			Integer lowJump) {
		return (addBasicBoundary(basicNav(page, totalPages, empty), page, totalPages, trigger, lowJump));
	}

//TODO to enhance
	/**
	 * 
	 * @param page
	 * @param totalPages
	 * @param amplitude
	 * @param empty
	 * @Note Concept on build
	 */
/*	private ArrayList<String> ligthNavigationVOnBuild(int page, int totalPages, int amplitude, String empty) {
		// Version on build
		// less amplitude accepted = 5;
		ArrayList<String> navigation = new ArrayList<String>();
		int delta = amplitude / 2;
		if (delta % 2 != 0) {
			delta = (amplitude / 2) - 1;
		}
		int lowestPage = (page - delta);
		int highestPage = (page + delta);
		if (page == 0 || totalPages == 0) {
			navigation.add(empty);
			return navigation;
		}
		if (totalPages <= amplitude + delta) {
			for (int i = 1; i <= totalPages; i++) {
				navigation.add(Integer.toString(i));
			}
			return navigation;
		}
		if (totalPages > amplitude) {

			if (lowestPage <= 1) {
				lowestPage = 1;
				highestPage = amplitude;
			}
			if (highestPage > amplitude) {
				highestPage = highestPage - 1;
			}
			if (highestPage > totalPages) {
				lowestPage = lowestPage - (highestPage - totalPages);
				highestPage = totalPages;
			}
			if (lowestPage <= 1) {

				lowestPage = 1;
				highestPage = amplitude;
			}
			if (highestPage > totalPages) {

				lowestPage = lowestPage - (highestPage - totalPages);
				highestPage = totalPages;
			}
			for (int i = lowestPage; i < page; i++) {
				navigation.add(Integer.toString(i));
			}
			for (int i = page; i <= highestPage; i++) {
				navigation.add(Integer.toString(i));
			}

		}
		return navigation;
	}
*/
	// TODO to enhance
	/**
	 * 
	 * @param page
	 * @param totalPages
	 * @param amplitude
	 * @param empty
	 * @param separator
	 * @Note Concept on build
	 */
/*	private ArrayList<String> mediumNavigation(int page, int totalPages, int amplitude, String empty,
			String separator) {
		ArrayList<String> navigation = new ArrayList<String>();
		String maxPage = Integer.toString(totalPages);
		// navigation = ligthNavigation(page, totalPages, amplitude, empty);
		if (!navigation.get(0).equals("1")) {
			navigation.add(0, separator);
			navigation.add(0, "1");
		}
		if (!navigation.get(navigation.size() - 1).equals(maxPage)) {
			navigation.add(separator);
			navigation.add(maxPage);
		}
		int pageLog = (int) Math.log10(page);
		int maxPageLog = (int) Math.log10(totalPages);
		if (page > 1 && page <= amplitude) {
			navigation.add(0, Integer.toString(-1));
		}
		if (page > amplitude) {
			navigation.add(0, Integer.toString(-1));
			if (amplitude * pageLog <= 0) {
				navigation.add(0, Integer.toString(-amplitude));
			} else {
				for (int i = 1; i <= pageLog; i++)
					navigation.add(0, Integer.toString((int) -(Math.pow(10, i)) / 2));
			}
		}
		return navigation;
	}

	// TODO to enhance
	/**
	 * 
	 * @param navigationBase
	 * @param totalPages
	 * @param separator
	 * @param first
	 * @param last
	 * @Note Concept on build
	 */
/*	private ArrayList<String> mediumNavigation(ArrayList<String> navigationBase, int totalPages, String separator,
			String first, String last) {
		ArrayList<String> navigation = new ArrayList<String>(navigationBase);
		String maxPage = Integer.toString(totalPages);

		if (!navigation.get(0).equals("1")) {
			navigation.add(0, separator);
			navigation.add(0, first);
		}
		if (!navigation.get(navigation.size() - 1).equals(maxPage)) {
			navigation.add(separator);
			navigation.add(last);
		}

		return navigation;
	}

	// TODO to enhance
	/**
	 * 
	 * @param page
	 * @param totalPages
	 * @param amplitude
	 * @param empty
	 * @param separator
	 * @Note Concept on build
	 * @throws ArithmeticException
	 */
/*	private ArrayList<String> heavyNavigation(int page, int totalPages, int amplitude, String empty, String separator)
			throws ArithmeticException {
		ArrayList<String> navigation = new ArrayList<String>();
		int delta = amplitude / 2;
		if (delta % 2 != 0) {
			delta = (amplitude / 2) - 1;
		}
		int interval = delta / 2;

		// navigation = ligthNavigation(page, totalPages, amplitude, empty);
		if (totalPages <= amplitude + delta) {
			return navigation;
		}
		int lowestPage = Integer.parseInt(navigation.get(0));
		int lastNavIndex = navigation.size() - 1;
		int highestPage = Integer.parseInt(navigation.get(lastNavIndex));
		if ((lowestPage - delta) <= (0)) {
			for (int i = lowestPage - 1; i >= 1; i--) {
				navigation.add(0, Integer.toString((i)));
			}
			if (highestPage > amplitude) {
				navigation.remove(Integer.toString(highestPage));
			}
		}
		if ((lowestPage > delta)) {
			navigation.add(0, "..");
			for (int i = interval; i >= 1; i--) {
				navigation.add(0, Integer.toString((i)));
			}
			if (highestPage < (totalPages - interval)) {
				navigation.remove(Integer.toString(lowestPage));
			}
		}
		if (highestPage < totalPages) {
			if (highestPage < (totalPages - (interval))) {
				navigation.add("..");
				for (int i = 1; i <= interval; i++) {
					navigation.add(Integer.toString((totalPages - interval) + i));
				}
			} else {
				for (int i = 1; i <= (totalPages - highestPage); i++) {
					navigation.add(Integer.toString((highestPage) + i));
				}
			}
		}
		if (lowestPage > (totalPages - amplitude)) {
			for (int i = 0; i < ((amplitude - 1) - (totalPages - lowestPage)); i++) {

				navigation.add((interval + 1), Integer.toString((lowestPage - 1) - i));
			}
		}
		return navigation;
	}*/

}
