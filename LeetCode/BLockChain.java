import java.util.Formatter;

public class BLockChain {
	String getLatestBlock(int[] startBalances, int[][] pendingTransactions, int blockSize) {
		// TODO Auto-generated method stub

		String prevHash = "";
		String currentHash = "";
		for (int i = 0; i < 40; i++)
			prevHash += "0";

		String blockString = "";
		for (int i = 0; i < pendingTransactions.length;) {
			StringBuilder temp = new StringBuilder("[");
			int j = 0;
			while (i < pendingTransactions.length && j < blockSize) {
				if (pendingTransactions[i][2] <= startBalances[pendingTransactions[i][0]]) {
					temp.append("[" + pendingTransactions[i][0] + ", " + pendingTransactions[i][1] + ", "
							+ pendingTransactions[i][2] + "]");
					if (j + 1 != blockSize && i + 1 != pendingTransactions.length)
						temp.append(", ");
					startBalances[pendingTransactions[i][0]] -= pendingTransactions[i][2];
					startBalances[pendingTransactions[i][1]] += pendingTransactions[i][2];
					j++;
				}
				i++;
			}
			temp.append("]");			
			int nonce = 0;			
			currentHash = sha1(prevHash + ", " + nonce + ", " + temp);
			while (!currentHash.substring(0, 4).equals("0000")) {
				nonce++;
				currentHash = sha1(prevHash + ", " + nonce + ", " + temp);
			}	
			blockString = currentHash + ", " + prevHash + ", " + nonce + ", " + temp;
			prevHash = currentHash;
		}
		return blockString;
	}


	@SuppressWarnings("resource")
	String sha1(String text) {
		String sha1 = "";
		try {
			java.security.MessageDigest crypt = java.security.MessageDigest.getInstance("SHA-1");
			crypt.update(text.getBytes("UTF-8"));
			Formatter formatter = new Formatter();
			for (byte b : crypt.digest()) {
				formatter.format("%02x", b);
			}
			sha1 = formatter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] startBalances = { 5, 0, 0 };
		int[][] pendingTransactions = { { 0, 1, 5 }, { 1, 2, 5 }};
		int blockSize = 2;
		System.out.println(new BLockChain().getLatestBlock(startBalances, pendingTransactions, blockSize));

	}

}
