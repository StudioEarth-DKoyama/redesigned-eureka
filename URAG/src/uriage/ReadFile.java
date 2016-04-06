package uriage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uriageEntity.Branch;
import uriageEntity.Commodity;

/**
 *ファイル操作を扱うクラス
 *@author t_koyamadc
 */
class ReadFile {

	private final String commonPath = "C:\\Users\\t_koyamadc\\Documents\\uriageData\\";
	private final String braPath = commonPath + "‪branch.lst";
	private final String comPath = commonPath + "commodity.lst";

	/**
	 * 各ファイルの存在チェック
	 * @return
	 * */
	public List<String> checkFile() {

		List<String> errMsgLst = new ArrayList<String>();

		//支店定義ファイル存在チェック
		File braFile = new File("‪C:\\Users\\t_koyamadc\\Documents\\uriageData\\branch.lst");

		System.out.println(braFile);

		if(!(braFile.exists())) {
			errMsgLst.add("支店定義ファイルがありません。");
		}

		//商品定義ファイル存在チェック
		File comFile = new File(comPath);
		if(!(comFile.exists())) {
			errMsgLst.add("商品定義ファイルがありません。");
		}

		//エラーメッセージがあればそれらを表示し処理を終了する
		if (errMsgLst.size() != 0) {

			for (String eml : errMsgLst) {
				System.out.println(eml);
			}

			System.out.println("処理を終了します");
			System.exit(0);

		}

		List<String> rcdList = checkRecord();

		return null; //setResult(rcdList);


	}

	/**
	 * branchファイルを処理
	 **/
	public List<Branch> readBranch() {

		//ファイルを読み込む
		File file = new File(commonPath + braPath);

		List<Branch> braList = new ArrayList<Branch>();

	    try {
	        //ファイルを読み込む
	        FileReader fr = new FileReader(file.toString());
	        BufferedReader br = new BufferedReader(fr);

	        //1行ずつ読みこんで格納
	        String line;

	        while ((line = br.readLine()) != null) {

	        	String[] cols = line.split(",", -1);

//					//フォーマットが違ったら格納しない
//		        	if (MATCH_BRANCH_NUMBER.equals(cols[0].toString())	&& ) {

	        		//Branchエンティティに格納
	        		Branch bra = new Branch();
	        		bra.setBranchName(cols[0]);
	        		bra.setBranchName(cols[1]);

	        		braList.add(bra);

//		        	}
	        }

	        //終了処理
	        br.close();
	        fr.close();

	    } catch (IOException ex) {
	        //例外発生時処理
	        System.out.println(ex);
	    }

		return braList;
	}

	/**
	 * commodityファイルを処理
	 **/
	public List<Commodity> readCommodity() {

		//ファイルを読み込む
		File file = new File(commonPath + comPath);
		List<Commodity> comList = new ArrayList<Commodity>();

		try {
	        //ファイルを読み込む
	        FileReader fr = new FileReader(file.toString());
	        BufferedReader br = new BufferedReader(fr);

	        //1行ずつ読みこんで格納
	        String line;

	        while ((line = br.readLine()) != null) {

	        	String[] cols = line.split(",", -1);
        		//Branchエンティティに格納
	        	Commodity com = new Commodity();
        		com.setCommodityNumber(cols[0]);
        		com.setCommodityName(cols[1]);

        		comList.add(com);

	        }

	        //終了処理
	        br.close();
	        fr.close();

	    } catch (IOException ex) {
	        //例外発生時処理
	        System.out.println(ex);
	    }

		return comList;

    }


	/**
	 * 売上ファイルの読み込み
	 **/
	private List<String> checkRecord() {

        //ファイル名の一覧を取得する
        File file = new File("C:\\Users\\t_koyamadc\\Documents\\uriageData");
        File files[] = file.listFiles();

        List<String> rcdList = new ArrayList<String>();

        //取得した一覧を表示する
        for (int i=0; i<files.length; i++) {
            if ((files[i].toString().endsWith(".rcd"))) {
            	rcdList.add(files[i].toString());
            }
        }

        return rcdList;

	}

}
