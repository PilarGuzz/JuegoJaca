package elementos;

import java.util.Objects;

public class Element {
	
	protected ElementType type;

	
	
	public Element(ElementType tipo) {
		super();
		this.type = tipo;
	}

	@Override
	public String toString() {
		return "Elemento: " + type.name();
	}

	public ElementType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return type == other.type;
	}

}
