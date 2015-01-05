package booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import booking.Movie;

public class MovieDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public MovieDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Movie> getAllMoviesByDate(Date date) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
			ps = con.prepareStatement("SELECT id,name,movie_length,movie_year,country,start_date,description,cinema_id FROM movies WHERE start_date < ?");
			ps.setDate(1, new java.sql.Date(date.getTime()));
			rs = ps.executeQuery();
			List<Movie> names = new LinkedList<>();
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setCinemaId(rs.getInt("cinema_id"));
				movie.setCountry(rs.getString("country"));
				movie.setDescription(rs.getString("description"));
				movie.setYear(rs.getInt("movie_year"));
				movie.setName(rs.getString("name"));
				movie.setLength(rs.getInt("movie_length"));
				names.add(movie);
			}
			return names;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Collections.emptyList();
	}

	public List<Date> getAllMovieProjections(Movie movie, Date date) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
			ps = con.prepareStatement("SELECT p.movie_time FROM movies_projections mp JOIN projections p ON mp.projection_id = p.id "
					+ "JOIN movies m ON m.id = mp.movie_id "
					+ "WHERE mp.movie_id = ? AND date_add(m.start_date, INTERVAL 14 DAY) <= ?");
			ps.setInt(1, movie.getId());
			ps.setDate(2, new java.sql.Date(date.getTime()));
			rs = ps.executeQuery();
			List<Date> times = new LinkedList<>();
			while(rs.next()) {
				times.add(rs.getTime("movie_time"));
			}
			return times;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Collections.emptyList();
	}

	public int getFreeSeatsCount(Movie movie, Date date, int pid) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
			ps = con.prepareStatement("SELECT seats_available FROM movies_projections WHERE cinema_id = ? AND movie_id = ? AND projection_id = ? and current_date = ?");
			ps.setInt(1, movie.getCinemaId());
			ps.setInt(2, movie.getId());
			ps.setInt(3, pid);
			ps.setDate(4, new java.sql.Date(date.getTime()));
			rs = ps.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt("count");
			}
			return count;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public void saveSeats(Movie movie, Date date, int pid,	int seatsCount) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
			ps = con.prepareStatement("UPDATE movies_projections SET seats_available = (SELECT seats_available FROM movies_projections "
					+ "WHERE cinema_id = ? AND movie_id = ? AND projection_id = ?) + ?;");
			ps.setInt(1, movie.getCinemaId());
			ps.setInt(2, movie.getId());
			ps.setInt(3, pid);
			ps.setInt(4, seatsCount);
			ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> getProjections() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
			ps = con.prepareStatement("SELECT id, movie_time FROM projections");
			rs = ps.executeQuery();
			List<String> projections = new LinkedList<>();
			while(rs.next()) {
				projections.add(rs.getString("movie_time"));
			}
			return projections;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Collections.emptyList();
	}
}
