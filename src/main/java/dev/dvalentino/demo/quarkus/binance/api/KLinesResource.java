package dev.dvalentino.demo.quarkus.binance.api;

import dev.dvalentino.demo.quarkus.binance.client.BinanceRestClient;
import dev.dvalentino.demo.quarkus.binance.data.Candlestick;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Path("/api/v1/klines")
public class KLinesResource {

    private final BinanceRestClient binanceRestClient;

    public KLinesResource(@RestClient BinanceRestClient binanceRestClient) {
        this.binanceRestClient = binanceRestClient;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Candlestick> getKLines() {

        LocalDateTime currenTime = LocalDateTime.now();

        return binanceRestClient.getCandlestickBars("BTCUSDT", "1m", 5,
                currenTime.minusMinutes(15).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
                currenTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        );
    }
}
