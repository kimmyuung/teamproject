package Day01_설계;

public class Solution {
	
	    private static Map<Integer, Date> parkingLot;   //주차장 -> 입차, 출차 관리
	    private static Map<Integer, Integer> totalTimes;   //시간 저장 map

	    public int[] solution(int[] fees, String[] records) throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	        parkingLot = new HashMap<>();
	        totalTimes = new HashMap<>();

	        for (String str : records) {
	            //05:34 5961 IN
	            String[] record = str.split(" ");
	            Date time = sdf.parse(record[0]);
	            int carNum = Integer.parseInt(record[1]);

	            if(parkingLot.containsKey(carNum)) {
	                findTotalTimes(carNum, time);

	                parkingLot.remove(carNum);
	            } else {
	                parkingLot.put(carNum, time);
	            }
	        }

	        //차 전부 다 내보내기
	        if(!parkingLot.isEmpty()) {
	            List<Integer> keySet = new ArrayList<>(parkingLot.keySet());
	            Date outTime = sdf.parse("23:59");

	            for (int key : keySet) {
	                findTotalTimes(key, outTime);
	                
	                parkingLot.remove(key);
	            }
	        }

	        return findTotalCharges(fees);
	    }

	    //한 차량이 주차한 총 시간 구하기
	    private void findTotalTimes(int carNum, Date outTime) {
	        Date inTime = parkingLot.get(carNum);
	        long value = (outTime.getTime() - inTime.getTime())/60000;

	        if (totalTimes.containsKey(carNum)) {
	            value += totalTimes.get(carNum);
	        }

	        totalTimes.put(carNum, (int) value);
	    }

	    /*
	    fees[0] : 기본 시간(분)  180
	    fees[1] : 기본 요금(원)  5000
	    fees[2] : 단위 시간(분)  10
	    fees[3] : 단위 요금(원)  600
	     */
	     //한 차량이 내야 하는 총 요금 구하기
	    private int[] findTotalCharges(int[] fees) {
	        List<Integer> keySet = new ArrayList<>(totalTimes.keySet());
	        Collections.sort(keySet);

	        int[] answer = new int[keySet.size()];
	        int basicTime = fees[0];
	        int basicFee = fees[1];
	        int unitTime = fees[2];
	        int unitFee = fees[3];

	        for (int i = 0; i < keySet.size(); i++) {
	            int key = keySet.get(i);
	            int timeValue = totalTimes.get(key);

	            if(timeValue <= basicTime) {
	                answer[i] = basicFee;
	            } else {
	                answer[i] = (timeValue - basicTime) / unitTime * unitFee + basicFee;
	                if ((timeValue - basicTime) % unitTime != 0) {
	                    answer[i] += unitFee;
	                }
	            }
	        }

	        return answer;
	    }
	}

