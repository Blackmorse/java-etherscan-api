package io.goodforgod.api.etherscan.model;

/**
 * @author GoodforGod
 * @since 28.10.2018
 */
public class TxERC721 extends BaseTx {

    private long nonce;
    private String blockHash;
    private String tokenName;
    private String tokenSymbol;
    private String tokenDecimal;
    private int transactionIndex;
    private long gasPrice;
    private long cumulativeGasUsed;
    private long confirmations;

    // <editor-fold desc="Getters">
    public long getNonce() {
        return nonce;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String getTokenName() {
        return tokenName;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public String getTokenDecimal() {
        return tokenDecimal;
    }

    public int getTransactionIndex() {
        return transactionIndex;
    }

    public long getGasPrice() {
        return gasPrice;
    }

    public long getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    public long getConfirmations() {
        return confirmations;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "TxERC721{" +
                "nonce=" + nonce +
                ", blockHash='" + blockHash + '\'' +
                ", tokenName='" + tokenName + '\'' +
                ", tokenSymbol='" + tokenSymbol + '\'' +
                ", tokenDecimal='" + tokenDecimal + '\'' +
                ", transactionIndex=" + transactionIndex +
                ", gasPrice=" + gasPrice +
                ", cumulativeGasUsed=" + cumulativeGasUsed +
                ", confirmations=" + confirmations +
                "} " + super.toString();
    }
}
