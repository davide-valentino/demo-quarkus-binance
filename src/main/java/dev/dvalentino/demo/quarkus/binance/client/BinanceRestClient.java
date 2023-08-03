package dev.dvalentino.demo.quarkus.binance.client;

import dev.dvalentino.demo.quarkus.binance.data.Candlestick;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface BinanceRestClient {
    @GET
    @Path("/api/v1/klines")
    List<Candlestick> getCandlestickBars(
            @QueryParam("symbol") String symbol,
            @QueryParam("interval") String interval,
            @QueryParam("limit") Integer limit,
            @QueryParam("startTime") Long startTime,
            @QueryParam("endTime") Long endTime);
}
