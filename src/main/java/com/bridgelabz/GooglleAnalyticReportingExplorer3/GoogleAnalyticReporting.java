package com.bridgelabz.GooglleAnalyticReportingExplorer3;

import java.util.ArrayList;
import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseModel;
import com.bridgelabz.csvfileCreator.SummaryReportcsvandelelementAssigner;
import com.bridgelabz.inputReader.GaReprtInfoArrayList;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;

public class GoogleAnalyticReporting {

	public static void main(String[] args) {
		try {

			// taking JSON file path
			String jsonfilepath = args[0];

			// creating object of GaReportResponseFetcher
			GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher();

			// creating object of SummaryReportcsvandelelementAssigner class
			SummaryReportcsvandelelementAssigner summaryReportcsvandelelementAssignerObject = new SummaryReportcsvandelelementAssigner();

			// creating object GaReprtInfoArrayList class
			GaReprtInfoArrayList GaReprtInfoArrayListObject = new GaReprtInfoArrayList();

			// passing JSONpath and getting ArrayList of GaInputInfoModel class
			ArrayList<GaReportInputModel> gaReportInputInfoArrayList = GaReprtInfoArrayListObject
					.readInputJsonFile(jsonfilepath);

			for (int i = 0; i < gaReportInputInfoArrayList.size(); i++) {

				// making ArrayList of responseModel after passing one by one
				// gaReportInputInfoArrayList

				ArrayList<ResponseModel> responseModelArrayList = gaReportResponseFetcherObject
						.getResponse(gaReportInputInfoArrayList.get(i));

				// creating csv file by passing input info and response
				summaryReportcsvandelelementAssignerObject
						.responseElementmodelAssigner(gaReportInputInfoArrayList.get(i), responseModelArrayList.get(i));
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}