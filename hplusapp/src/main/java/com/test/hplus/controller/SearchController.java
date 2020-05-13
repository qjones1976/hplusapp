package com.test.hplus.controller;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AsyncTaskExecutor executor;

    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model,
                                         HttpServletRequest request) {
        DeferredResult<String> deferredResult = new DeferredResult<>();

        System.out.println("search");
        System.out.println("search: " + search);
        System.out.println("request.isAsyncSupported()" + request.isAsyncSupported());

/*        return () -> {
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            return "search";
        };*/

        executor.execute(
                ()-> {
                    List<Product> products = new ArrayList<>();
                    products = productRepository.searchByName(search);
                    model.addAttribute("products", products);
                    deferredResult.setResult("search");
                }

        );
        return deferredResult;
    }
}
