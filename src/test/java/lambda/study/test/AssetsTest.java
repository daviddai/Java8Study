package lambda.study.test;

import lambda.study.Asset;
import lambda.study.Assets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AssetsTest {

    private Assets assets;

    @Before
    public void init() {
        List<Asset> assetList = Arrays.asList(
                new Asset(Asset.AssetType.BOND, 10),
                new Asset(Asset.AssetType.STOCK, 20),
                new Asset(Asset.AssetType.BOND, 30),
                new Asset(Asset.AssetType.BOND, 40),
                new Asset(Asset.AssetType.STOCK, 50),
                new Asset(Asset.AssetType.BOND, 60),
                new Asset(Asset.AssetType.STOCK, 70)
        );
        assets = new Assets(assetList);
    }

    @Test
    public void testGetTotalAssetBondValue() {
        final int totalAssetBondValue = 140;
        Assert.assertEquals("The total asset bond value is " + totalAssetBondValue,
                totalAssetBondValue, assets.getTotalAssetBondValue());
    }

    @Test
    public void testGetTotalAssetStockValue() {
        final int totalAssetStockValue = 140;
        Assert.assertEquals("The total asset stock value is " + totalAssetStockValue,
                totalAssetStockValue, assets.getTotalAssetStockValue());
    }

    @Test
    public void testGetTotalAssetValue() {
        final int totalAssetValue = 280;
        Assert.assertEquals("The total asset value is " + totalAssetValue,
                totalAssetValue, assets.getTotalAssetValue());
    }
}
