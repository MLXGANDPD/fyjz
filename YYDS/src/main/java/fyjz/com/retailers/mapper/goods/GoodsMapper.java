package fyjz.com.retailers.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    //根据商品分类id查询相关商品
    List<Goods> findGoodsByCategoryId(@Param("cid")Long cid,@Param("start")Integer start,@Param("pagesize")Integer pagesize);
    
    //根据分类id查询商品的总数量
    Integer findGoodsNumByCategoryId(Long cid);
    
    //根据商品的分类ID去查询分类的名字
    String findCategoryNameByGoodsCategoryId(Long cid);

    
    //根据商品数量获取商品数量
	int findGoodsNumByGoodId(int id);

	
	//修改商品数量
	void updateCartItemByIdMapper(@Param("id")int goodsId,@Param("n")int num);
	
}