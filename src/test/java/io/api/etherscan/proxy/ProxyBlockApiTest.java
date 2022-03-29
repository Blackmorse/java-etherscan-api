package io.api.etherscan.proxy;

import io.api.ApiRunner;
import io.api.etherscan.core.impl.EtherScanApi;
import io.api.etherscan.manager.impl.QueueManager;
import io.api.etherscan.model.EthNetwork;
import io.api.etherscan.model.proxy.BlockProxy;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 03.11.2018
 */
class ProxyBlockApiTest extends ApiRunner {

    private final EtherScanApi api;

    ProxyBlockApiTest() {
        final QueueManager queueManager = new QueueManager(1, 5100L, 5100L, 0);
        this.api = new EtherScanApi(getApiKey(), EthNetwork.MAINNET, queueManager);
    }

    @Test
    void correct() {
        Optional<BlockProxy> block = api.proxy().block(5120);
        assertTrue(block.isPresent());
        BlockProxy proxy = block.get();
        assertNotNull(proxy.getHash());
        assertNotNull(proxy.getNumber());
        assertNotNull(proxy.getParentHash());
        assertNotNull(proxy.getStateRoot());
        assertNotNull(proxy.getSize());
        assertNotNull(proxy.getDifficulty());
        assertNotNull(proxy.getTotalDifficulty());
        assertNotNull(proxy.getTimeStamp());
        assertNotNull(proxy.getMiner());
        assertNotNull(proxy.getNonce());
        assertNotNull(proxy.getHash());
        assertNotNull(proxy.getExtraData());
        assertNotNull(proxy.getLogsBloom());
        assertNotNull(proxy.getMixHash());
        assertNotNull(proxy.getGasUsed());
        assertNotNull(proxy.getGasLimit());
        assertNotNull(proxy.getSha3Uncles());
        assertNotNull(proxy.getTransactions());
        assertNotNull(proxy.getTransactionsRoot());
        assertNotNull(proxy.getReceiptsRoot());
        assertNotNull(proxy.getUncles());
        assertNotNull(proxy.toString());

        BlockProxy empty = new BlockProxy();
        assertNotEquals(proxy, empty);
        assertNotEquals(proxy.hashCode(), empty.hashCode());
    }

    @Test
    void correctParamWithEmptyExpectedResult() {
        Optional<BlockProxy> block = api.proxy().block(99999999999L);
        assertFalse(block.isPresent());
    }

    @Test
    void correctParamNegativeNo() {
        Optional<BlockProxy> block = api.proxy().block(-1);
        assertTrue(block.isPresent());
        assertNotNull(block.get().getHash());
    }
}
