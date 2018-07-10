package lambda.study;

import java.util.List;
import java.util.function.Predicate;

public class Assets {

    private List<Asset> assets;

    public Assets(final List<Asset> assets) {
        this.assets = assets;
    }

    public void add(Asset asset) {
        assets.add(asset);
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public int getTotalAssetBondValue() {
        return totalAssetValue(asset -> asset.getType() == Asset.AssetType.BOND);
    }

    public int getTotalAssetStockValue() {
        return totalAssetValue(asset -> asset.getType() == Asset.AssetType.STOCK);
    }

    public int getTotalAssetValue() {
        return totalAssetValue(asset -> true);
    }

    private int totalAssetValue(Predicate<Asset> assetSelector) {
        return assets
                .stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
