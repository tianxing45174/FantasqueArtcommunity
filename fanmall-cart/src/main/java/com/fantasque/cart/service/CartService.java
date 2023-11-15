package com.fantasque.cart.service;

import com.fantasque.cart.vo.CartItemVo;
import com.fantasque.cart.vo.CartVo;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author LaFantasque
 * @version 1.0
 */
public interface CartService {
    CartVo getCart()throws ExecutionException, InterruptedException;

    CartItemVo addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    CartItemVo getCartItem(Long skuId);

    void changeItemCount(Long skuId, Integer num);

    void checkItem(Long skuId, Integer check);

    void deleteIdCartInfo(Integer skuId);

    List<CartItemVo> getUserCartItems();

    void clearCartInfo(String cartKey);
}
