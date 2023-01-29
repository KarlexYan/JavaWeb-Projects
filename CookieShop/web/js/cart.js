// 购物车前端JavaScript，负责实时显示数据
/**
 * 加入购物车
 */
function buy(goodid){
    /*指向GoodsBuyServlet 传入参数goodsid 回调函数function(data)*/
	$.post("goods_buy", {goodsid:goodid}, function(data){
		if(data=="ok")
		{
			layer.msg("添加到购物车!", {time:800}, function(){
               location.reload();
            });
		}
		else if(data=="fail")
		{
            layer.msg("库存不足,请购买其他商品!", {time:800}, function(){

            });
		}
		/*if(data=="ok"){
			layer.msg("操作成功!", {time:800}, function(){
				location.reload();
			});
		}else if(data=="login"){
			alert("请登录后购买!");
			location.href="login.jsp";
		}else if(data=="empty"){
			alert("库存不足!");
			location.reload();
		}else{
			alert("请求失败!");
		}*/

	});
}
/**
 * 购物车减少商品数量
 */
function lessen(goodsid){
    /*指向GoodsLessenServlet 传入参数goodsid 回调函数function(data)*/
    $.post("goods_lessen", {goodsid:goodsid}, function(data){
        if(data=="ok"){
            layer.msg("操作成功!", {time:800}, function(){
                location.reload();
            });
        }
//		if(data=="ok"){
//			layer.msg("操作成功!", {time:800}, function(){
//				location.href="cart.action";
//			});
//		}else if(data=="login"){
//			alert("请登录后操作!");
//			location.href="login.jsp";
//		}else{
//			alert("请求失败!");
//		}
    });
}
/**
 * 购物车删除
 */
function deletes(goodid){
    /*指向GoodsDeleteServlet 传入参数goodsid 回调函数function(data)*/
    $.post("goods_delete", {goodsid:goodid}, function(data){
        if(data=="ok"){
            layer.msg("删除成功!", {time:800}, function(){
                location.reload();
            });
        }
    });
}