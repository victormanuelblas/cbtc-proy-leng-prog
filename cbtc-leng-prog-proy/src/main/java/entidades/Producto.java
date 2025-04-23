package entidades;

public class Producto {
	private int productoId;
	private String codigo;
	private String nombre;
	private int categoriaId;
	private String categoria;
	private Double precio;
	private String fechaCreacion;
	private int stock;
	private int stockMax;
	private int stockMin;
	private int estadoId;
	private String estado;
	
	
	public Producto(int productoId, String codigo, String nombre, int categoriaId, String categoria, Double precio, String fechaCreacion,
			int stock, int stockMax, int stockMin, int estadoId, String estado) {
		super();
		this.productoId = productoId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoriaId = categoriaId;
		this.categoria = categoria;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.stock = stock;
		this.stockMax = stockMax;
		this.stockMin = stockMin;
		this.estadoId = estadoId;
		this.estado = estado;
	}

	public Producto(String codigo, String nombre, int categoriaId, String categoria, Double precio, String fechaCreacion,
			int stock, int stockMax, int stockMin, int estadoId, String estado) {
		super();
		this.productoId = 0;
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoriaId = categoriaId;
		this.categoria = categoria;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.stock = stock;
		this.stockMax = stockMax;
		this.stockMin = stockMin;
		this.estadoId = estadoId;
		this.estado = estado;
	}

	public Producto(String codigo, String nombre, int categoriaId, Double precio, String fechaCreacion,
			int stock, int stockMax, int stockMin, int estadoId) {
		super();
		this.productoId = 0;
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoriaId = categoriaId;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.stock = stock;
		this.stockMax = stockMax;
		this.stockMin = stockMin;
		this.estadoId = estadoId;
	}
	
	public Producto(int productoId, String codigo, String nombre, String categoria, Double precio, String fechaCreacion,
			int stock, int stockMax, int stockMin, String estado) {
		super();
		this.productoId = productoId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.stock = stock;
		this.stockMax = stockMax;
		this.stockMin = stockMin;
		this.estado = estado;
	}

	public Producto() {
		this(0,"", "",0, "", 0.0, "" , 0, 0 , 0 , 1, "");
	}


	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMax() {
		return stockMax;
	}

	public void setStockMax(int stockMax) {
		this.stockMax = stockMax;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public int getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
