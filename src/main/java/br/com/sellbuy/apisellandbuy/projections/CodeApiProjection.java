package br.com.sellbuy.apisellandbuy.projections;

import br.com.sellbuy.apisellandbuy.entities.Codes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "code", url = "https://ciprand.p3p.repl.co/api")
public interface CodeApiProjection {

    @GetMapping("?len={leng}&count={coun}")
    String getCode(@PathVariable("leng") Integer leng, @PathVariable("coun") Integer coun);
}
