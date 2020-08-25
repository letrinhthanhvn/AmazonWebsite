package com.amazonweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amazonweb.service.ICatalogService;
import com.amazonweb.service.IProductService;

@Controller
public class HomeController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICatalogService catalogService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
//		System.out.println("All products: " + productService.getAllProduct().size());
		mav.addObject("productModel", productService.getAllProduct());
		mav.addObject("catalogModel", catalogService.getAllCatalog());
		mav.addObject("firstItem", productService.newList().get(0));
		mav.addObject("secondItem", productService.newList().get(1));
		mav.addObject("thirdItem", productService.newList().get(2));
		return mav;
	}
//  
//   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//   public ModelAndView springMVCPage() {
//      ModelAndView mav = new ModelAndView("springmvc");
//      return mav;
//   }
}