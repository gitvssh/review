//package logic;
//
//import java.util.List;
//
//import dao.ItemDao;
//
//public class ItemCatalogImpl implements ItemCatalog {
//
//	private ItemDao itemDao;
//	
//	public void setItemDao(ItemDao itemDao) {
//		this.itemDao = itemDao;
//	}
//
//	@Override
//	public List<Item> getItemList() {
//		return this.itemDao.findAll();
//	}
//
//	@Override
//	public Item getItemByItemId(Integer item_id) {
//		return this.itemDao.findByPrimaryKey(item_id);
//	}
//
//}
