package booking;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import booking.dao.MovieDAO;

@WebService
public class BookingWebService {

	MovieDAO movieDao = new MovieDAO();
	
	@WebMethod
	public List<Movie> getAllMoviesByDate(@WebParam Date date) {
		return movieDao.getAllMoviesByDate(date);
	}

	@WebMethod
	public List<Date> getAllMovieProjections(@WebParam Movie movie, @WebParam Date date) {
		return movieDao.getAllMovieProjections(movie, date);
	}

	@WebMethod
	public int getFreeSeatsCount(@WebParam Movie movie, @WebParam Date date, @WebParam int projection) {
		return movieDao.getFreeSeatsCount(movie, date, projection);
	}

	@WebMethod
	public void saveSeats(@WebParam Movie movie, @WebParam Date date, @WebParam int projection, @WebParam int seatsCount) {
		movieDao.saveSeats(movie, date, projection, seatsCount);
	}

	@WebMethod
	public List<String> getProjections() {
		return movieDao.getProjections();
	}
}
