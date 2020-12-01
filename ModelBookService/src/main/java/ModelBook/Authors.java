package ModelBook;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Authors implements Comparable<Authors> {
	public int Id;
	public String firstName;
	public String lastName;
	public int birthDate;
	public int hireDate;
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getDate() {
		return this.birthDate;
	}
	public void setHireDate(int hireDate) {
		this.hireDate = hireDate;
	}

	public int getHireDate() {
		return this.hireDate;
	}
	@Override
	public String toString() {
		String buf_str = "";
		buf_str = buf_str + firstName + "\t" + lastName +"\t" + birthDate + "\t" + hireDate + "\n";
		return buf_str;
	}
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass()!=o.getClass()) return false;
		Authors that = (Authors) o;
		return firstName.equals(that.firstName) && lastName.equals(that.lastName);

	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName,lastName,birthDate,hireDate);
	}

	@Override
	public int compareTo(@NotNull Authors o) {
		return Integer.compare(o.getHireDate() - o.getDate(), 0);
	}
}
