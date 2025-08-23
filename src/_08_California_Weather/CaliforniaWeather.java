package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton cityButton = new JButton("city");
JButton weatherButton = new JButton("weather");
JButton temperatureButton = new JButton("temperature");
    void start() {
    	frame.add(panel);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	panel.add(cityButton);
    	panel.add(weatherButton);
    	panel.add(temperatureButton);
    	cityButton.addActionListener(this);
    	weatherButton.addActionListener(this);
    	temperatureButton.addActionListener(this);
    	frame.pack();
    	
    	
       
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) (e.getSource());
		if (buttonPressed == cityButton) {
		        
		        // All city keys have the first letter capitalized of each word
		        String cityName = Utilities.capitalizeWords( JOptionPane.showInputDialog("input a city name!"));
		        //String cityName = Utilities.capitalizeWords( "National City" );
		        WeatherData datum = weatherData.get(cityName);
		        //cityName = JOptionPane.showInputDialog("input a city name!");
		        if( datum == null ) {
		            System.out.println("Unable to find weather data for: " + cityName);
		        } else {
		            JOptionPane.showMessageDialog(null, cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		        }
		}
		if(buttonPressed == weatherButton) {
			ArrayList<String> cities = new ArrayList<String>();
			String output = "";
			String weatherCondition = Utilities.capitalizeWords(JOptionPane.showInputDialog("input some weather data!"));
			int outputNum = 0;
			for(Entry<String,WeatherData> entry: weatherData.entrySet()) {
				String city = entry.getKey();
				WeatherData wd = entry.getValue();
				if(wd.weatherSummary.contains(weatherCondition)) {
					cities.add(city);
					outputNum ++;
					if(outputNum %10 == 0) {
					output += "\n";
					}
					output += city+ ", ";
				}
			}
			JOptionPane.showMessageDialog(null, output);
		}
		if(buttonPressed == temperatureButton) {
			String temperatureRange = Utilities.capitalizeWords(JOptionPane.showInputDialog("input a range of temperatures!"));
			
		}
	}
}
