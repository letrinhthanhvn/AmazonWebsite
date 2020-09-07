package com.amazonweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonweb.model.ShoppingCart;
import com.amazonweb.service.IShoppingCartService;
import com.amazonweb.utils.MessageUtil;
import com.amazonweb.utils.ShoppingCart.MessageReponseId;

@RestController
public class ShoppingCartAPI {
	
	@Autowired
	private IShoppingCartService service;

//	private class Param extends  ShoppingCart {
//		private Long userId;
//
//		public void setUserId(Long userId) {
//			this.userId = userId;
//		}
//
//		@Override
//		public Long getUserId() {
//			return userId;
//		}
//	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/users/shoppingCart/create", method = RequestMethod.POST)
	public ResponseEntity<Object> addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		MessageReponseId messageSuccess = new MessageReponseId();
		MessageUtil<ShoppingCart> message = new MessageUtil<>();
		if (shoppingCart.getUserId() == null) {
			message.setMessage("UserId must be not null!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else if (shoppingCart.getLastUpdate() == null) {
			message.setMessage("Update time must be not null!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else if (shoppingCart.getStatusId() == null) {
			message.setMessage("Status must be not null");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else if (shoppingCart.getShippingInfo() == null) {
			message.setMessage("Shipping info must be not null");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else if (shoppingCart.getTotalPrice() == null) {
			message.setMessage("Total price must be not null");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {
			Long checkStatus = service.findShoppingCartByStatusIdAndUserId(shoppingCart.getUserId());
			if (checkStatus == null) {
				Long id = service.createShoppingCart(shoppingCart);
				if (id == null) {
					message.setMessage("Can not create shopping cart!");
					return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
				} else {
					messageSuccess.setMessage("Create Shopping Cart successed");
					messageSuccess.setId(id);
					return new ResponseEntity<>(messageSuccess, HttpStatus.CREATED);
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
