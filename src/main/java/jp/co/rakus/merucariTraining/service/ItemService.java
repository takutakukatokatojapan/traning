package jp.co.rakus.merucariTraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.merucariTraining.domain.Category;
import jp.co.rakus.merucariTraining.domain.Item;
import jp.co.rakus.merucariTraining.repository.CategoryRepository;
import jp.co.rakus.merucariTraining.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
/*-----------------------------------------------------------------
						itemクラス
------------------------------------------------------------------*/	
	/**
	 * offsetとなる引数がない場合のメッソド
	 * @return itemRepository.findLimit20ByOffset(offset);
	 */
	public List<Item> displayFirstTime(){
		return itemRepository.findLimit20ByOffset(0);
	}
	
	/**
	 * offsetとなる引数がある場合のメッソド
	 * @param page sessionの値である現在のページ位置（Integer）
	 * @param pageValue　htmlから受け取ったページ推移の為の数字(Integer)
	 * @return itemRepository.findLimit20ByOffset(pageElement);
	 */
	public List<Item> findItemByPage(Integer page, Integer pageValue){
		Integer pageElement = (page+pageValue)*30+1;
		return itemRepository.findLimit20ByOffset(pageElement);
	}
	
	/**
	 * ページ数を計算するメッソド
	 * 総ページ数を計算
	 * @param listSize
	 * @return　Integer (総ページ数)
	 */
	public Integer culcPage(Integer listSize) {
		List<Item> itemListOnlyId = itemRepository.findItemAllOnlyId();
		Integer allPage = itemListOnlyId.size()/listSize+1;
		return allPage;
	}
	
	/**
	 * String型の引数をString型の0で返すメソッド
	 * @param pageNumber　(String)
	 * @return String
	 */
	public String changePageNumberTo0(String pageNumber) {
		Integer newPageNumber = Integer.parseInt(pageNumber);
		newPageNumber = 0;
		String finalNumber = String.valueOf(newPageNumber);
		return finalNumber;
	}
	
	/**
	 * itemをidで検索するメソッド
	 * @param id
	 * @return itemRepository.findItemById(id)
	 */
	public Item findItembyId(Integer id) {
		return itemRepository.findItemById(id);
	}
	
	/**
	 * category_name(親、子、孫)を三つ受取結合し,categoryを返すメソッド
	 * @param nameOfParent
	 * @param nameOfChild
	 * @param nameOfGrandChild
	 * @return　Integer(itemsテーブルのcategory)
	 */
	/*public Integer findCategoryFromItemByCategoryName(String nameOfParent, String nameOfChild, String nameOfGrandChild) {
		String nameAll = nameOfParent+"||"+nameOfChild+"||"+nameOfGrandChild;
		Integer category = itemRepository.findItemCategoryByCategoryName(nameAll);
		return category;
	}*/
	
	/**
	 * ３つの文字列をInteger型に変換する
	 * @param parent　String
	 * @param child String
	 * @param grandChild String
	 * @return Integer (itemsのcategory)
	 */
	/*public Integer changeCategory(String parent, String child, String grandChild) {
		String categoryName = parent+"/"+child+"/"+grandChild;
		Integer id = itemRepository.findItemCategoryByCategoryName(categoryName);
		return id;
	}*/
		
	/**
	 * itemのinsert
	 * @param item
	 * @return
	 */
	public Item insertItem(Item item) {
		return itemRepository.insertItem(item);
	}
	
	/**
	 * id検索でitemを探し出す
	 * @param item
	 * @return
	 */
	public Item findItemByIdNew(Integer id) {
		return itemRepository.findItemByIdNew(id);
	}
	/**
	 * itemのupdate 
	 * @param item
	 * @return
	 */
	public Item updateItem(Item item) {
		return itemRepository.updateItem(item);
	}
	
	/**
	 * itemの名前を全て取り配列に変換する
	 * @return　
	 */
/*	public String[] createArrayForAutocompleteOfName(){
		List<Item> itemList = itemRepository.findItemNameAll();
		String[] nameArray = new String[itemList.size()];
		for (int i = 0; i < nameArray.length; i++) {
			nameArray[i] = itemList.get(i).getName();
		}
		return nameArray;
	}
	*/
	/**
	 * name,category(String),brandの検索メソッド
	 * @param name
	 * @param category
	 * @param brand
	 * @return
	 */
	public List<Item> findItemByNameAndCategoryOnStringAndBrand1(String name, String category, String brand){
		return itemRepository.findItemByNameAndCategoryOnStringAndBrand1(name, category, brand);
	}
	public List<Item> findItemByNameAndCategoryOnStringAndBrand2(String name, String category, String brand){
		return itemRepository.findItemByNameAndCategoryOnStringAndBrand2(name, category, brand);
	}
	public List<Item> findItemByNameAndCategoryOnIntegerAndBrand(String name, Integer category, String brand){
		return itemRepository.findItemByNameAndCategoryOnIntegerAndBrand(name, category, brand);
	}
	
	public List<Item> findItemByNameAndCategoryOnString1(String name, String category){
		return itemRepository.findItemByNameAndCategoryOnString1(name, category);
	}
	public List<Item> findItemByNameAndCategoryOnString2(String name, String category){
		return itemRepository.findItemByNameAndCategoryOnString2(name, category);
	}
	public List<Item> findItemByNameAndCategoryOnInteger(String name, Integer category){
		return itemRepository.findItemByNameAndCategory(name, category);
	}
	
	public List<Item> findItemByNameAndBrand(String name, String brand){
		return itemRepository.findItemByNameAndBrand(name, brand);
	}
	
	public List<Item> findItemByCategoryOnStringAndBrand1(String category, String brand){
		return itemRepository.findItemByCategoryOnStringAndBrand1(category, brand);
	}
	public List<Item> findItemByCategoryOnStringAndBrand2(String category, String brand){
		return itemRepository.findItemByCategoryOnStringAndBrand2(category, brand);
	}
	public List<Item> findItemByCategoryOnIntegerAndBrand(Integer category, String brand){
		return itemRepository.findItemByCategoryAndBrand(category, brand);
	}
	
	public List<Item> findItemByName(String name){
		return itemRepository.findItemByName(name);
	}
	
	public List<Item> findItemByCategoryOnString1(String category){
		return itemRepository.findItemByCategoryOnString1(category);
	}
	public List<Item> findItemByCategoryOnString2(String category){
		return itemRepository.findItemByCategoryOnString2(category);
	}
	public List<Item> findItemByCategoryOnInteger(Integer category){
		return itemRepository.findItemByCategory(category);
	}
	
	public List<Item> findItemByBrand(String brand){
		return itemRepository.findItemByBrand(brand);
	}
/*-------------------------------------------------------------------------	
							ajax(categoryクラス)
--------------------------------------------------------------------------*/	
	
	/**
	 * カテゴリーの親要素を返す
	 * @return List<Category>
	 */
	public List<Category> findParent(){
		return categoryRepository.findNameAllSplit1();
	}
	
	/**
	 * カテゴリーの子要素を返す
	 * @param name String
	 * @return　List<Category>
	 */
	public List<Category> findChils(Integer id){
		return categoryRepository.findNameAllSplit2ByName(id);
	}
	
	/**
	 * カテゴリーの孫要素を返す
	 * @param name String
	 * @return　List<Category>
	 */
	public List<Category> findGrandChild(Integer id){
		return categoryRepository.findNameAllSplit3ByName(id);
	}
	
	
	
	/**
	 * カテゴリーの親要素を引数としてcategoryのリストを返す
	 * @param name
	 * @return
	 */
	public List<Category> findChild(String name){
		return categoryRepository.findNameAllSplit2ForNameAll(name);
	}
	
	public List<Category> findGrandChild(String name){
		System.out.println("子供の名前チェック【junit確認用】:" + name);
		return categoryRepository.findNameAllSplit3ForNameAll(name);
	}
	
	/**
	 * autocomplete機能を実装するJQueryに配列を渡す為のメソッド
	 * @param categoryList (List<Category>) 今回は文字補完のリストを変換する為に使用
	 * @return String[]
	 */
	public String[] createArrayForAutoComplete(List<Category> categoryList) {
		String[] categoryName = new String[categoryList.size()];
		for (int i = 0; i < categoryList.size(); i++) {
			categoryName[i] = categoryList.get(i).getNameAll();
		}
		return categoryName;
	}
/*------------------------------------------------------------------------
								ajax(itemクラス)
------------------------------------------------------------------------*/	
	/**
	 * autocomplete機能（ブランド用）を実装するJQueryに配列を渡す為のメソッド
	 * @return　String[]
	 */
	public String[] createArrayForAutoCompleteOfBrand() {
		List<Item> itemList = itemRepository.findAllBrand();
		String[] brandArray = new String[itemList.size()];
		for (int i = 0; i < brandArray.length; i++) {
			brandArray[i] = itemList.get(i).getBrand();
		}
		return brandArray;
	}
}
