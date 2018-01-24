package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	public TbItemMapper itemMapper;
	@Override
	public TbItem findItemById(long id) {
		return itemMapper.selectByPrimaryKey(id);
	}
	@Override
	public DataGridResult pageQueryItems(int page, int rows) {
		DataGridResult result = new DataGridResult();
		//设置分页数据
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		//获取总数
		long total = pageInfo.getTotal();
		result.setRows(list);
		result.setTotal(total);
		return result;
	}

}
