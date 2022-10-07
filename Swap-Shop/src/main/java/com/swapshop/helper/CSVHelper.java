package com.swapshop.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.swapshop.entity.Product;


public class CSVHelper {

	public static String Type="text/csv";
	static String[] Headers= {"productdescription","productimage", "productname", "productprice", "productstock", "productsize"};
	public static boolean hasCSVFormat(MultipartFile file) {
		
	    if (!Type.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	
	public static List<Product> csvToProducts(InputStream is){
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvparser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			
						List<Product> products = new ArrayList<Product>();
						Iterable<CSVRecord> csvrecords = csvparser.getRecords(); 
						
						for(CSVRecord csvrecord :csvrecords) {
							com.swapshop.entity.Product product = new Product();
							product.setProductdescription(csvrecord.get("productdescription"));
							product.setProductimage(csvrecord.get("productimage"));
							product.setProductname(csvrecord.get("productname"));
							product.setProductprice(Double.parseDouble(csvrecord.get("productprice")));
							product.setProductstock(Integer.parseInt(csvrecord.get("productstock")));
							product.setProductsize(csvrecord.get("productsize"));
							products.add(product);		
					}
					return products;	
			
		}catch(Exception e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
	
	public static ByteArrayInputStream productsToCSV(List<Product> products) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		try(ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);){
			for(Product product:products) {
				List<String> data = Arrays.asList(
						
						product.getProductname(),
						product.getProductdescription(),
						String.valueOf(product.getProductprice()),
						String.valueOf(product.getProductstock()));
						product.getProductstock();
				
				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());	
		}catch(Exception e) {
			throw new RuntimeException("Fail to import data to CSVFile: "+e.getMessage());
		}	
	}


}
