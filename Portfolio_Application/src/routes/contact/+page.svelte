<script lang="ts">
  let fullname = '';
  let email = '';
  let message = '';

   async function handleSubmit(event: Event): Promise<void> {
    event.preventDefault();

    const data = {
      fullname,
      email,
      message
    };

    try {
      const res = await fetch('http://localhost:8081/api/contacts/contact', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
      });

      if (res.ok) {
        alert('Message sent successfully!');
        fullname = '';
        email = '';
        message = '';
      } else {
        const text = await res.text();
        console.error('Server error:', text);
        alert('Failed to send message');
      }
    } catch (err) {
      console.error(err);
      alert('Network error');
    }
  }
</script>

<main>
  <h1>Contact Us</h1>
  <form on:submit={handleSubmit}>
    <input type="text" placeholder="Full Name" bind:value={fullname} required />
    <input type="email" placeholder="Email" bind:value={email} required />
    <!-- <input type="tel" placeholder="Mobile Number" bind:value={mobile} required pattern="[0-9]{10}" /> -->
    <textarea placeholder="Your Message" bind:value={message} required></textarea>
    <button type="submit">Send</button>
  </form>
</main>

<style>
  main {
    padding: 2rem;
    max-width: 600px;
    margin: auto; 
    background-color: var(--bg-color);
    color: var(--text-color);
  }

  h1 {
    text-align: center;
    color: #1e1e1e;
    margin-bottom: 2rem;
  }

  form {
    display: flex;
    margin-right: 2rem;
    flex-direction: column;
    gap: 1rem;
  }

  input, textarea {
    padding: 0.75rem 1rem;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 100%;
  }

  textarea {
    resize: vertical;
    min-height: 120px;
  }

  button {
    padding: 0.75rem 1rem;
    font-size: 1rem;
    border: none;
    border-radius: 4px;
    background-color: #19c22a;
    color: white;
    cursor: pointer;
    transition: background 0.3s;
  }

  button:hover {
    background-color: #22148c;
  }
</style>


