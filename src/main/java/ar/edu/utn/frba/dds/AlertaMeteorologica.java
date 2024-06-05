package ar.edu.utn.frba.dds;

public enum AlertaMeteorologica {
  TORMENTA {
    @Override
    public String getMensaje() {
      return "Tormenta eléctrica en la zona";
    }
  },
  GRANIZO {
    @Override
    public String getMensaje() {
      return "Granizo en la zona";
    }
  },
  NIEVE {
    @Override
    public String getMensaje() {
      return "Nieve en la zona";
    }
  };

  public abstract String getMensaje();

  public static AlertaMeteorologica fromString(String str) {
    return switch (str) {
      case "STORM" -> TORMENTA;
      case "HAIL" -> GRANIZO;
      case "SNOW" -> NIEVE;
      default -> null;
    };
  }
}
