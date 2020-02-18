package designmode.structure.bridge.demo03;

/**
 * 购买交通票
 * @author 王浩
 *
 */
public abstract class Buy {

	// 购买票是不是可以在不同的提供商
	private Provider provider;

	public Buy(Provider provider) {
		setProvider(provider);
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public abstract void buy();
}
