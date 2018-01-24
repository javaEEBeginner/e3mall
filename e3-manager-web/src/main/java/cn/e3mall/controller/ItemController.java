package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	public ItemService itemService;
	/**
	 * 根据url地址输入的id查询商品
	 * @param itemId
	 * @return 
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable long itemId){
		TbItem item = itemService.findItemById(itemId);
		return item;
	}
	/**
	 * 分页查询所有的商品
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItems(int page,int rows){
		DataGridResult result = itemService.pageQueryItems(page, rows);
		return result;
	}
}
