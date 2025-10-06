<script>
  // Your projects data
  const projects = [
    {
      title: "Weather API",
      description: "A web app that fetches real-time weather data using an open weather API with location-based updates.",
      link: "#"
    },
    {
      title: "Portfolio",
      description: "A personal portfolio website built using Svelte with dark mode, responsive design, and interactive UI.",
      link: "#"
    },
    {
      title: "E-Commerce Website",
      description: "A simple e-commerce platform with product listings, cart functionality, and secure checkout flow.",
      link: "#"
    }
  ];
</script>

<main>
  <section class="hero">
    <h1>Welcome to My Portfolio 🚀</h1>
    <p>Hi, I'm <strong>Kundan Kumar Singh</strong> — a passionate software Developer focused on building clean, efficient web applications.</p>
  </section>

  <section class="projects">
    <h2>My Projects</h2>
    <div class="card-container">
      {#each projects as project}
        <div class="card">
          <h3>{project.title}</h3>
          <p>{project.description}</p>
          <a href={project.link} target="_blank" class="btn">View Project</a>
        </div>
      {/each}
    </div>
  </section>
</main>

<style>
  main {
    padding: 2rem;
    background-color: var(--bg-color);
    color: var(--text-color);
  }

  .hero {
    text-align: center;
    margin-bottom: 3rem;
  }

  .hero h1 {
    font-size: 2rem;
    margin-bottom: 0.5rem;
    color:rgb(241, 30, 73);
  }

  .hero p {
    font-size: 1.1rem;
    color: var(--text-color);
  }

  .projects h2 {
    text-align: center;
    margin-bottom: 1.5rem;
    font-size: 1.8rem;
  }

  .card-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 1.5rem;
    justify-items: center;
  }

  .card {
    background-color: var(--header-bg);
    color: var(--header-text);
    border: 1px solid #444;
    border-radius: 12px;
    padding: 1.5rem;
    text-align: center;
    width: 100%;
    max-width: 300px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.2);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
  }

  .card:hover {
    transform: translateY(-6px);
    box-shadow: 0 6px 12px rgba(0,0,0,0.3);
  }

  .card h3 {
    margin-bottom: 0.5rem;
    color: var(--header-text);
  }

  .btn {
    display: inline-block;
    margin-top: 1rem;
    padding: 0.6rem 1.2rem;
    background-color: #0078ff;
    color: white;
    border-radius: 6px;
    text-decoration: none;
    font-weight: bold;
    transition: background-color 0.3s ease;
  }

  .btn:hover {
    background-color: #005fcc;
  }
</style>



