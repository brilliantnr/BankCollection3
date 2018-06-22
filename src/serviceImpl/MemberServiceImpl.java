package serviceImpl;
//Map
import java.util.*;
import domain.*;
import service.MemberService;
	
public class MemberServiceImpl implements MemberService {
	Map<String,MemberBean> map; //
	
	public MemberServiceImpl() {
		map = new HashMap<>(); 
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		map.put(user.getUid(),user);
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("1234");
		map.put(staff.getUid(),staff);
	}

	@Override
	public Map<String,MemberBean> list() {
		return map;
	}

	@Override
	public List<MemberBean> findByName(String name) { //이름 똑같은애 찾아라
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>(); // set은 인덱스없음. 소량일때사용
		for (Map.Entry<String, MemberBean> e : map.entrySet()) {// ★★★★ 1:多 인 상태 //Entry는 (키값 상관없이) 객체
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());
			}
		}
		Iterator<MemberBean> it = set.iterator();
		while (it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}

		/*for(int i=0;i<map.size();i++) {  //size() =>데이터양에 따라 칸이 증식=> 최적의 횟수만 돈다.
					if(param.equals(map.get(i).getName())) {   //list[i]  =list.get(i)   
						temp.add(map.get(i));
					}
				}*/
	

	@Override
	public MemberBean findById(MemberBean member) {
	System.out.println("찾는 아이디에 해당하는 이름 : "+map.get(member.getUid()));
		return map.get(member.getUid());  //
	}

	@Override
	public void updatePassword(MemberBean member) {  
		String id = member.getUid();
		String oldPass = member.getPw().split("/")[0];
		String newPass = member.getPw().split("/")[1];
		MemberBean mem = map.get(member.getUid());
		if(mem == null) {
			System.out.println("수정하려는 ID가 없음!");
		}else {
			if(oldPass.equals(mem.getPw())) {
				mem.setPw(newPass);
				map.put(id, mem);
			}
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		map.remove(member.getUid());
		//list.remove(search(member));
	}
}
