package com.devsu.cuentamovimientos.feign.client;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.response.RespBase;
import com.devsu.cuentamovimientos.response.dto.ClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(name = "clientPersonApi", url = "${private.base.url.clientperson}")
public interface ClientPersonApiClient {
	@GetMapping(value = Constants.ENDPOINT_OBTENER_CLIENT_PERSON, produces = { MediaType.APPLICATION_JSON_VALUE })
	ClientDTO getClientPersonById(@PathVariable("id") Long id);
}
