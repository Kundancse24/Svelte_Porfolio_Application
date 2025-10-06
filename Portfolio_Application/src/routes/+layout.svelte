<script>
  import { onMount } from "svelte";

  let showDropdown = false;
  let darkMode = false;

	// Optional: save mode in localStorage
  onMount(() => {
    const savedMode = localStorage.getItem("darkMode");
    if (savedMode === "true") darkMode = true;
    updateTheme();
  });

  function toggleDropdown() {
    showDropdown = !showDropdown;
  }

  function toggleDarkMode() {
    darkMode = !darkMode;
    localStorage.setItem("darkMode", darkMode);
    updateTheme();
  }

  function updateTheme() {
    if (darkMode) { 
			document.documentElement.classList.add("dark");
		}
    else {
			document.documentElement.classList.remove("dark");
		}
  }
</script>

<header>
  <div class="logo">Portfolio </div>

  <nav>
    <!-- Dropdown button -->
    <div style="position: relative;">
      <button class="dropdown-btn" on:click={toggleDropdown}>Menu ▼</button>
      {#if showDropdown}
        <div class="dropdown-menu">
          <a href="/">Home</a>
          <a href="/about">About Us</a>
          <a href="/contact">Contact</a>
        </div>
      {/if}
    </div>

    <!-- Dark/Light toggle -->
    <button class="toggle-btn" on:click={toggleDarkMode}>
      {darkMode ? "☀ Light" : "🌙 Dark"}
    </button>
  </nav>
</header>

<slot /> <!-- page content -->

<footer>
  <p>&copy; 2025 Portfolio App. All rights reserved.</p>
  
  <div class="social-icons">
    <a href="https://github.com/yourusername" target="_blank" aria-label="GitHub">
      <i class="fab fa-github"></i>
    </a>
    <a href="https://linkedin.com/in/yourusername" target="_blank" aria-label="LinkedIn">
      <i class="fab fa-linkedin"></i>
    </a>
    <a href="https://twitter.com/yourusername" target="_blank" aria-label="Twitter">
      <i class="fab fa-x-twitter"></i>
    </a>
    <a href="mailto:yourname@gmail.com" aria-label="Email">
      <i class="fas fa-envelope"></i>
    </a>
  </div>
</footer>


<style>
  :global(:root) {
    --bg-color: #ffffff;
    --text-color: #000000;
    --header-bg: #ffffff;
    --header-text: #000000;
    --footer-bg: #f2f2f2;   
    --footer-text: #000000;
  }

  :global(.dark) {
    --bg-color: #6b727f;
    --text-color: #ffffff;
    --header-bg: #6b727f;
    --header-text: #ffffff;
    --footer-bg: #6b727f;
    --footer-text: #ffffff;
  }

  html, body {
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
  background-color: var(--bg-color);
  color: var(--text-color);
  font-family: sans-serif;
  }

  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1rem 2rem;
    background-color: var(--bg-color);
    border-bottom: 1px solid #e0dede;
    color: var(--text-color);
  }

  .logo {
    font-size: 1.5rem;
    font-weight: bold;
  }

  nav {
    position: relative;
    display: flex;
    align-items: center;
    gap: 1rem;
  }

  .dropdown-btn, .toggle-btn {
    cursor: pointer;
    padding: 0.5rem 1rem;
    background: none;
    border: none;
    color: var(--header-text);
    border-radius: 4px;
  }

  .dropdown-btn:hover, .toggle-btn:hover {
    background-color: #555;
  }

  .dropdown-menu {
    position: absolute;
    right: 0;
    top: 100%;
    background-color: var(--header-bg);
    border: 1px solid #333;
    border-radius: 4px;
    display: flex;
    flex-direction: column;
    width: 150px;
    margin-top: 0.5rem;
    z-index: 10;
  }

  .dropdown-menu a {
    padding: 0.5rem 1rem;
    color: var(--header-text);
    text-decoration: none;
  }

  .dropdown-menu a:hover {
    background-color: #555;
  }

  footer {
  text-align: center;
  padding: 1.5rem;
  background-color: var(--bg-color);
  color: var(--text-color);
  border-top: 1px solid #e0dede;
  }

  .social-icons {
  margin-top: 0.75rem;
  display: flex;
  justify-content: center;
  gap: 1rem;
  }

  .social-icons a {
  color: var(--text-color);
  font-size: 1.5rem;
  transition: transform 0.3s ease, color 0.3s ease;
  }

  .social-icons a:hover {
  color: #0077ff;
  transform: scale(1.2);
  }


</style>


