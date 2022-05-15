package com.cb.cartolascraping.outbound;

import com.cb.cartolascraping.dto.ParciaisResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "parciaiscartola", url = "https://novo.parciaiscartola.com.br/API/ServicesCartola/ObterParciaisLigaV2?liga=liga-remosa-2022&time=&versao=08052022164412")
public interface ParciaisCartolaClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    ParciaisResponse getParciais();
}
