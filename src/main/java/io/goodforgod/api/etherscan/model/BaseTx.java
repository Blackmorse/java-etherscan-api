package io.goodforgod.api.etherscan.model;

import com.google.gson.annotations.Expose;
import io.goodforgod.api.etherscan.util.BasicUtils;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

/**
 * @author GoodforGod
 * @since 28.10.2018
 */
abstract class BaseTx {

    long blockNumber;
    String timeStamp;
    @Expose(deserialize = false, serialize = false)
    LocalDateTime _timeStamp;
    String hash;
    String from;
    String to;
    BigInteger value;
    String contractAddress;
    String input;
    BigInteger gas;
    BigInteger gasUsed;

    // <editor-fold desc="Getter">
    public long getBlockNumber() {
        return blockNumber;
    }

    public LocalDateTime getTimeStamp() {
        if (_timeStamp == null && !BasicUtils.isEmpty(timeStamp))
            _timeStamp = LocalDateTime.ofEpochSecond(Long.parseLong(timeStamp), 0, ZoneOffset.UTC);
        return _timeStamp;
    }

    public String getHash() {
        return hash;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigInteger getValue() {
        return value;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public String getInput() {
        return input;
    }

    public BigInteger getGas() {
        return gas;
    }

    public BigInteger getGasUsed() {
        return gasUsed;
    }
    // </editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BaseTx))
            return false;

        BaseTx baseTx = (BaseTx) o;

        if (blockNumber != baseTx.blockNumber)
            return false;
        if (!Objects.equals(timeStamp, baseTx.timeStamp))
            return false;
        if (!Objects.equals(hash, baseTx.hash))
            return false;
        if (!Objects.equals(from, baseTx.from))
            return false;
        if (!Objects.equals(to, baseTx.to))
            return false;
        return Objects.equals(value, baseTx.value);
    }

    @Override
    public int hashCode() {
        int result = (int) (blockNumber ^ (blockNumber >>> 32));
        result = 31 * result + (timeStamp != null
                ? timeStamp.hashCode()
                : 0);
        result = 31 * result + (hash != null
                ? hash.hashCode()
                : 0);
        result = 31 * result + (from != null
                ? from.hashCode()
                : 0);
        result = 31 * result + (to != null
                ? to.hashCode()
                : 0);
        result = 31 * result + (value != null
                ? value.hashCode()
                : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTx{" +
                "blockNumber=" + blockNumber +
                ", timeStamp='" + timeStamp + '\'' +
                ", hash='" + hash + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", value=" + value +
                ", contractAddress='" + contractAddress + '\'' +
                ", input='" + input + '\'' +
                ", gas=" + gas +
                ", gasUsed=" + gasUsed +
                '}';
    }
}
