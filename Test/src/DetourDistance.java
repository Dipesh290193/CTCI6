
public class DetourDistance {

	public static class point {

		private double longitude, latitude;

		public point() {
		}

		public point(double longitude, double latitude) {
			this.longitude = longitude;
			this.latitude = latitude;
		}

		public double getLongitude() {
			return this.longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		public double getLatitude() {
			return this.latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
	}

	public static void main(String args[]) {
		point a = new point(10, 50);
		point b = new point(60, 50);
		point c = new point(10, 20);
		point d = new point(60, 20);

		double distAB = getDistance(a, b);
		double distCD = getDistance(c, d);

		if (distAB > distCD) {
			System.out.println("Path should be ACDB");
		} else if (distAB < distCD) {
			System.out.println("Path should be CABD");
		} else {
			System.out.println("Any of them Driver can do it !...");
		}
	}

	public static double getDistance(point x, point y) {
		double radiusofEarth = 3963.17;
		double diffLatitude = Math.toRadians(x.latitude - y.latitude);
		double diffLongitude = Math.toRadians(x.longitude - y.longitude);
		double lat1 = Math.toRadians(x.latitude);
		double lat2 = Math.toRadians(y.latitude);

		// Haversine Formula
		// http://en.wikipedia.org/wiki/Haversine_formula
		double a = Math.pow(Math.sin(diffLatitude / 2), 2)
				+ Math.pow(Math.sin(diffLongitude / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = radiusofEarth * c;

		return distance;
	}
}
