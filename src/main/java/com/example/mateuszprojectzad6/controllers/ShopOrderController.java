package com.example.mateuszprojectzad6.controllers;

//import com.example.mateuszprojectzad6.models.ShopProductList;
import com.example.mateuszprojectzad6.services.ShopOrderItemService;
import com.example.mateuszprojectzad6.services.ShopProductService;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShopOrderController
{

    @Autowired
    private ShopProductService shopProductService;

    @Autowired
    private ShopOrderItemService shopOrderItemService;

    /*
    //Lista
    private List<ShopProduct> shopProductList;


    public List<ShopProduct> findAll() {return this.shopProductList;}


    public ShopProduct find(Long id) {
        for (ShopProduct shopProduct : this.shopProductList) {
            if (shopProduct.getId()==id) {
                return shopProduct;
            }
        }
        return null;
    }
     */

    /*
    @GetMapping("/ProductPage")
    public String viewCategoriesPage(Model model) {
        model.addAttribute("listShopProducts", shopService.getShopProducts());
        return "/OrderPage";
    }
     */

    /*
    @GetMapping("/OrderPage")
    public String index(Model model) {
        model.addAttribute("items", shopProductList);
        return "/OrderPage";
    }
     */

    @GetMapping("/OrderPage")
    public ModelAndView OrderPage() {
        ModelAndView modelAndView = new ModelAndView("/OrderPage");
        modelAndView.addObject("products", shopOrderItemService.getProductsInCart());
        modelAndView.addObject("total", shopOrderItemService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("/shoppingCart/addProduct/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Long productId) {
        shopProductService.findById(productId).ifPresent(shopOrderItemService::addProduct);
        return OrderPage();
    }

    @GetMapping("/shoppingCart/removeProduct/{productId}")
    public ModelAndView removeProductFromCart(@PathVariable("productId") Long productId) {
        shopProductService.findById(productId).ifPresent(shopOrderItemService::removeProduct);
        return OrderPage();
    }

    @GetMapping("/shoppingCart/checkout")
    public ModelAndView checkout()
    {
        /*
        try {
            shopOrderService.checkout();
        } catch (NotEnoughProductsInStockException e) {
            return shoppingCart().addObject("outOfStockMessage", e.getMessage());
        }
        return shoppingCart();
         */
        return OrderPage();
    }


    /*
    @GetMapping("buy/{id}")
    public String buy(@PathVariable("id") Long id, HttpSession session) {
        //ShopProductList shopProductList = new ShopProductList();
        if (session.getAttribute("order") == null) {
            List<ShopProductInOrder> order = new ArrayList<ShopProductInOrder>();
            order.add(new ShopProductInOrder(find(id), 1));
            session.setAttribute("order", order);
        } else {
            List<ShopProductInOrder> order = (List<ShopProductInOrder>) session.getAttribute("order");
            int index = this.exists(id, order);
            if (index == -1) {
                order.add(new ShopProductInOrder(find(id), 1));
            } else {
                int quantity = order.get(index).getQuantity() + 1;
                order.get(index).setQuantity(quantity);
            }
            session.setAttribute("order", order);
        }
        return "redirect:/OrderPage";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") Long id, HttpSession session) {
        //ShopProductList shopProductList = new ShopProductList();
        List<ShopProductInOrder> order = (List<ShopProductInOrder>) session.getAttribute("order");
        int index = this.exists(id, order);
        order.remove(index);
        session.setAttribute("order", order);
        return "redirect:/OrderPage";
    }

    private int exists(Long id, List<ShopProductInOrder> order) {
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getShopProduct().getId()==id) {
                return i;
            }
        }
        return -1;
    }
     */


}
