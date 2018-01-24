package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	
	public TbItem findItemById(long id);
	public DataGridResult pageQueryItems(int page,int rows);
}
