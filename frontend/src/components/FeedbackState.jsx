function FeedbackState({ title, description, role = "status", actionLabel, onAction, compact = false }) {
  return (
    <section
      className={`feedback-state${compact ? " feedback-state--compact" : ""}`}
      role={role}
      aria-live="polite"
    >
      <h2>{title}</h2>
      {description && <p>{description}</p>}
      {onAction && (
        <button type="button" className="feedback-state__action" onClick={onAction}>
          {actionLabel}
        </button>
      )}
    </section>
  );
}

export function LoadingState({ label = "Cargando información...", compact = false }) {
  return <FeedbackState title={label} compact={compact} />;
}

export function ErrorState({ message, onRetry, compact = false }) {
  return (
    <FeedbackState
      title="No pudimos cargar la información"
      description={message}
      role="alert"
      actionLabel="Reintentar"
      onAction={onRetry}
      compact={compact}
    />
  );
}

export function EmptyState({ title, description, compact = false }) {
  return <FeedbackState title={title} description={description} compact={compact} />;
}
