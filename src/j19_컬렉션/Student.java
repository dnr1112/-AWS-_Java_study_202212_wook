package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor	// 기본 생성자
//@RequiredArgsConstructor
@AllArgsConstructor		// 전체 생성자
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
public class Student {
	private String name;	// 이름
	private int year;	// 학년
//	private final String address; 
}
