package com.amazonweb.api;

import com.amazonweb.api.form.ShoppingCartProductForm;
import com.amazonweb.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonweb.model.ShoppingCart;
import com.amazonweb.model.ShoppingCartProduct;
import com.amazonweb.service.IShoppingCartProductService;
import com.amazonweb.utils.MessageUtil;
import com.amazonweb.utils.ShoppingCart.MessageReponseId;

import java.util.List;

@RestController
public class ShoppingCartProductAPI {

    private class Message {
        private String message;
        private List<ShoppingCartProduct> data;

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setData(List<ShoppingCartProduct> data) {
            this.data = data;
        }

        public List<ShoppingCartProduct> getData() {
            return data;
        }
    }

    @Autowired
    private IShoppingCartProductService service;

    @Autowired
    private IShoppingCartService shoppingCartSerivce;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/users/shoppingCartProduct/create", method = RequestMethod.POST)
    // params: product_id, user_id, quantity, discount
    public ResponseEntity<Object> insertShoppingCartProduct(@RequestBody ShoppingCartProductForm shoppingCartProductParam) {
        MessageUtil<ShoppingCart> message = new MessageUtil<>();
        MessageReponseId messageSuccess = new MessageReponseId();
        if (shoppingCartProductParam.getUserId() == null) {
            message.setMessage("UserId must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (shoppingCartProductParam.getProductId() == null) {
            message.setMessage("ProductId must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (shoppingCartProductParam.getDiscount() == null) {
            message.setMessage("Discount must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            Long idShoppingCart = shoppingCartSerivce.findShoppingCartByStatusIdAndUserId(shoppingCartProductParam.getUserId());
            if (idShoppingCart != null) {
                ShoppingCartProduct item = service.getByProductIdAndShoppingCartId(shoppingCartProductParam.getProductId(), idShoppingCart);
                if (item == null) {
                    ShoppingCartProduct newShoppingCartProduct = new ShoppingCartProduct();
                    newShoppingCartProduct.setShoppingCartId(idShoppingCart);
                    newShoppingCartProduct.setDiscount(shoppingCartProductParam.getDiscount());
                    newShoppingCartProduct.setQuantity(shoppingCartProductParam.getQuantity());
                    newShoppingCartProduct.setProductId(shoppingCartProductParam.getProductId());
                    Long id = service.insertShoppingCartProduct(newShoppingCartProduct);
                    if (id == null) {
                        messageSuccess.setMessage("Insert Shopping Cart Product failed!");
                        return new ResponseEntity<>(messageSuccess, HttpStatus.OK);
                    } else {
                        messageSuccess.setMessage("Insert Shopping Cart Product successed!");
                        messageSuccess.setId(id);
                        return new ResponseEntity<>(messageSuccess, HttpStatus.OK);
                    }
                } else {
                    item.setQuantity(item.getQuantity() + shoppingCartProductParam.getQuantity());
                    service.updateShoppingCartProduct(item);
                    messageSuccess.setMessage("Insert Shopping Cart Product successed!");
                    return new ResponseEntity<>(messageSuccess, HttpStatus.OK);
                }
            } else {
                message.setMessage("Something happened!");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/users/allShoppingCartProduct/get-all", method = RequestMethod.POST)
    public ResponseEntity<Object> getAll(@RequestBody ShoppingCartProductForm shoppingCartProductForm) {
        Message message = new Message();
        if (shoppingCartProductForm.getUserId() == null) {
            message.setMessage("UserId must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (shoppingCartProductForm.getDiscount() == null) {
            message.setMessage("Discount must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (shoppingCartProductForm.getProductId() == null) {
            message.setMessage("ProductId must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (shoppingCartProductForm.getQuantity() == null) {
            message.setMessage("Quantity must be not null!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            Long idShoppingCart = shoppingCartSerivce.findShoppingCartByStatusIdAndUserId(shoppingCartProductForm.getUserId());
            if (idShoppingCart != null) {
                List<ShoppingCartProduct> results = service.getAll(idShoppingCart);
                message.setMessage("Get all product in shopping cart successed!");
                message.setData(results);
                return new ResponseEntity<>(message, HttpStatus.OK);
            } else {
                return null;
            }
        }

    }
}
