package kr.co.yangdoll.domain;

import java.util.Objects;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardVO {
	Integer bno;
	String title;
	String content;
	String writer;
	String regdate; 
	String updatedate;
	@Override
	public int hashCode() {
		return Objects.hash(bno, content, title, writer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return Objects.equals(bno, other.bno) && Objects.equals(content, other.content)
				&& Objects.equals(title, other.title) && Objects.equals(writer, other.writer);
	}
	
}
