package br.com.sellbuy.apisellandbuy.services;

import br.com.sellbuy.apisellandbuy.entities.Codes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "code", url = "https://ciprand.p3p.repl.co/api?")
public interface CodeApiService {
    @GetMapping("len={leng}&count={coun}")
    Codes gerCode(@PathVariable("leng") String leng, @PathVariable("coun") String coun);
}
