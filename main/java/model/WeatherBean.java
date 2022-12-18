package model;

public class WeatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	private String tempStr;
	
	private String dateStr;

	  // JavaBean for city & country
	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;
		
	}

	        // CITY	
	public String getCityStr() {
		return cityStr;
	}

	        // COUNTRY
	public String getCountryStr() {
		return countryStr;
	}

	        // CLOUDS
	public String getCloudsStr() {
		return cloudsStr;
	}

		public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
		
		     // TEMPERATURE
		public String getTempStr() {
			return tempStr;
		}

			public void setTempStr(String tempStr) {
			this.tempStr = tempStr;
		}
			
	          // DATE
			
			public String getDateStr() {
				return dateStr;
			}

				public void setDateStr(String dateStr) {
				this.dateStr = dateStr;
			}
				
			
			
		
		
		
		
		
		
		
		
		
		
		

}