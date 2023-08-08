package dev.dvalentino.demo.quarkus.binance.data;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(
        shape = JsonFormat.Shape.ARRAY
)
@JsonPropertyOrder
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public record Candlestick(
        Long openTime,
        String open,
        String high,
        String low,
        String close,
        String volume,
        Long closeTime,
        String quoteAssetVolume,
        Long numberOfTrades,
        String takerBuyBaseAssetVolume,
        String takerBuyQuoteAssetVolume) {
}
